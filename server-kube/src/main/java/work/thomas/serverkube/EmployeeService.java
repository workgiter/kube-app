package work.thomas.serverkube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EmployeeService {
        /**
     * has the code to request the database.
     */
    EmployeeRepository employeeRepo;

    /**
     * Set's the employee repo.
     *
     * @param newEmployeeRepo sdf
     */
    @Autowired
    public void setEmployeeRepo(final EmployeeRepository newEmployeeRepo) {
        this.employeeRepo = newEmployeeRepo;
    }

    /**
     * return list of employee data from mongodb.
     * @return employee data from mongodb
     */
    public Employees getEmployeesData() {
        Employees data = new Employees(employeeRepo.findAll());
        return data;
    }

    private void checkEmployeeValid(final Employee emp) {
        if (emp.getName().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
            "no name sent");
        }
        if (emp.getEmail().equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
            "no email sent");
        }
        if (emp.getAge() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
            "age invalid");
        }
    }

    /**
     * adds new employee to database.
     * @param employeeJSON string json data of employee to be added
     * @throws JsonMappingException
     * @throws JsonProcessingException
     * @return employee saved to database
     */
    public Employee addNewEmployee(final String employeeJSON)
        throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Employee emp = mapper.readValue(employeeJSON, Employee.class);
        checkEmployeeValid(emp);
        return employeeRepo.save(
            new Employee(emp.getName(), emp.getEmail(), emp.getAge())
        );
    }

    /**
     * edits data for employee in mongodb.
     * @param employeeJSON
     * @throws JsonMappingException
     * @throws JsonProcessingException
     * @return employee edited in database
     * @throws NotFoundException
     */
    public Employee editEmployee(final String employeeJSON)
    throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Employee emp = mapper.readValue(employeeJSON, Employee.class);
        checkEmployeeValid(emp);
        Employee returnEmp;
        if (employeeRepo.existsById(emp.getId())) {
            returnEmp = employeeRepo.save(emp);
        } else {
            returnEmp = null;
        }
        if (returnEmp == null) {
            //throw new NotFoundException();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            "ID not found");
        }

        return returnEmp;
    }

    /**
     * kjh.
     * @param employeeId
     */
    public void deleteEmployee(final String employeeId) {

    }
}
