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

@RestController
@RequestMapping(path = "/people")
@CrossOrigin(origins = "*")
public class EmployeeController {

    /**service to transform and interact with mongodb. */
    @Autowired
    EmployeeService employeeService; // = new EmployeeService();

    // /**asdf. */
    // EmployeeController() {
    //     employeeService = new EmployeeService();
    // }

    // /**
    //  * Set's the employee service.
    //  *
    //  * @param newEmployeeService
    //  */
    // public void setEmployeeRepo(final EmployeeService newEmployeeService) {
    //     this.employeeService = newEmployeeService;
    // }

    /**
     * handles get request and sends back full database to client.
     *
     * @return full employee database in json
     */
    @GetMapping(path = "/", produces = "application/json")
    public Employees namesGET() {
        //Employees data = new Employees(employeeRepo.findAll());
        return employeeService.getEmployeesData();
    }

    /**
     * Function to handle post requests.
     * Takes in json body, maps into the employee object,
     * and then saves it to database.
     *
     * @param employee
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    @PostMapping("/")
    @ResponseBody
    public void namePOST(@RequestBody final String employee)
            throws JsonMappingException, JsonProcessingException {
        employeeService.addNewEmployee(employee);

    }

    /**
     * changes data for single employee.
     *
     * @param employee
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    @PostMapping("/edit")
    @ResponseBody
    public void editPOST(@RequestBody final String employee)
            throws JsonMappingException, JsonProcessingException {
                employeeService.editEmployee(employee);
    }
}
