package work.thomas.serverkube;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    /**
     * handles get request and sends back full database to client.
     *
     * @return full employee database in json
     */
    @GetMapping(path = "/", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Employees namesGET() {
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
     * @return employee saved to database
     */
    @PostMapping("/")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Employee namePOST(@RequestBody final String employee)
    throws JsonMappingException, JsonProcessingException {
        return employeeService.addNewEmployee(employee);

    }

    /**
     * changes data for single employee.
     *
     * @param employee
     * @throws JsonMappingException
     * @throws JsonProcessingException
     * @return employee edited in database
     * @throws NotFoundException
     */
    @PostMapping("/edit")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Employee editPOST(@RequestBody final String employee)
    throws JsonMappingException, JsonProcessingException {
        return employeeService.editEmployee(employee);
    }

    /**
     * delete employee with employee id from mongodb.
     * @param employeeId
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable("id") final String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}
