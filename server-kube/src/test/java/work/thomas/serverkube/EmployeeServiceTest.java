package work.thomas.serverkube;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class EmployeeServiceTest {

    /** making return data object for use in testing. */
    EmployeeService returnData;

    /** Mock mongodb repository for employee data. */
    @Mock
    EmployeeRepository employeeRepository;

    /** set's up mocks for testing. */
    @BeforeEach
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
        returnData = new EmployeeService();
        returnData.setEmployeeRepo(employeeRepository);
    }

    /** tests get request function to see if data is in the right format. */
    @Test
    public void testGET() {
        Assertions.assertTrue(
            returnData.getEmployeesData() instanceof Employees
        );
    }

    /**
     * tests post request function to see if it adds right
     * data format into database.
     */
    @Test
    public void testPOST() {
        try {
            final int agePram = 10;
            final Employee exampleEmployee =
             new Employee("name", "email", agePram);

            when(employeeRepository.save(any(Employee.class)))
            .thenReturn(exampleEmployee);

            returnData.addNewEmployee(
                "{\"name\":\"name\",\"email\":\"email\",\"age\":10}"
            );

            ArgumentCaptor<Employee> savedCaptor =
             ArgumentCaptor.forClass(Employee.class);

            verify(employeeRepository).save(savedCaptor.capture());
            assertTrue(savedCaptor.getValue().getName().equals("name"));
            assertTrue(savedCaptor.getValue().getEmail().equals("email"));
            assertTrue(savedCaptor.getValue().getAge() == agePram);

        } catch (JsonMappingException e) {
            e.printStackTrace();
            assertTrue(false);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    /**test to see if function saves data with right format. */
    @Test
    public void testEditEmployee() {
        try {
            final int agePram = 10;
            Employee exampleEmployee =
                new Employee("name", "email", agePram);
            exampleEmployee.setId("asdf");


            when(employeeRepository.save(any(Employee.class)))
            .thenReturn(exampleEmployee);
            when(employeeRepository.existsById("asdf"))
            .thenReturn(true);


            returnData.editEmployee(
            "{\"id\":\"asdf\",\"name\":\"name\",\"email\":\"email\",\"age\":10}"
            );

            ArgumentCaptor<Employee> savedCaptor =
             ArgumentCaptor.forClass(Employee.class);

            verify(employeeRepository).save(savedCaptor.capture());
            assertTrue(savedCaptor.getValue().getId().equals("asdf"));
            assertTrue(savedCaptor.getValue().getName().equals("name"));
            assertTrue(savedCaptor.getValue().getEmail().equals("email"));
            assertTrue(savedCaptor.getValue().getAge() == agePram);

        } catch (JsonMappingException e) {
            e.printStackTrace();
            assertTrue(false);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            assertTrue(false);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

    }

    /** test the delete employee function
     * to see if it sends the right datatype
     * to the reposatory function. */
    @Test
    public void testDeleteEmployee() {

        returnData.deleteEmployee("asdf");

        ArgumentCaptor<String> savedCaptor =
        ArgumentCaptor.forClass(String.class);

       verify(employeeRepository).deleteById(savedCaptor.capture());
       assertTrue(savedCaptor.getValue().equals("asdf"));
    }
}
