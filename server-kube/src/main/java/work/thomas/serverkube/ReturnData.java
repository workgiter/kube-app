package work.thomas.serverkube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/people")
@CrossOrigin(origins = "*")
public class ReturnData {
    /**
     * has the code to request the database.
     */
    EmployeeRepository employeeRepo;

    /**
     * Set's the employee repo.
     *
     * @param newEmployeeRepo
     */
    @Autowired
    public void setEmployeeRepo(final EmployeeRepository newEmployeeRepo) {
        this.employeeRepo = newEmployeeRepo;
    }

    /**
     * handles get request and sends back full database to client.
     *
     * @return full employee database in json
     */
    @GetMapping(path = "/", produces = "application/json")
    public Employees namesGET() {
        Employees data = new Employees(employeeRepo.findAll());
        return data;
    }

    /**
     * Function to handle post requests.
     * Takes in json body, maps into the employee object,
     * and then saves it to database.
     *
     * @param product
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    @PostMapping("/")
    @ResponseBody
    public void namePOST(@RequestBody final String product)
            throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Employee emp = mapper.readValue(product, Employee.class);
        employeeRepo.save(new Employee(emp.name, emp.email, emp.age));

    }

}
