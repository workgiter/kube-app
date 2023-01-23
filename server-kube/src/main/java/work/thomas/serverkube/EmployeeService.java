package work.thomas.serverkube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    /**
     * adds new employee to database.
     * @param employeeJSON string json data of employee to be added
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    public void addNewEmployee(final String employeeJSON)
        throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Employee emp = mapper.readValue(employeeJSON, Employee.class);
        employeeRepo.save(
                new Employee(emp.getName(), emp.getEmail(), emp.getAge()));
    }

    /**
     * edits data for employee in mongodb.
     * @param employeeJSON
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    public void editEmployee(final String employeeJSON)
        throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Employee emp = mapper.readValue(employeeJSON, Employee.class);
        employeeRepo.save(emp);
    }
}
