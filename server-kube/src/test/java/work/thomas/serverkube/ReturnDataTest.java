package work.thomas.serverkube;

import static org.junit.jupiter.api.Assertions.assertTrue;
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

public class ReturnDataTest {

    /** making return data object for use in testing. */
    ReturnData returnData;

    /** Mock mongodb repository for employee data. */
    @Mock
    EmployeeRepository employeeRepository;

    /** set's up mocks for testing. */
    @BeforeEach
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
        returnData = new ReturnData();
        returnData.setEmployeeRepo(employeeRepository);
    }

    /** tests get request function to see if data is in the right format. */
    @Test
    public void testGET() {
        Assertions.assertTrue(returnData.namesGET() instanceof Employees);
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

            when(employeeRepository.save(exampleEmployee))
            .thenReturn(exampleEmployee);

            returnData.namePOST(
                "{\"name\":\"name\",\"email\":\"email\",\"age\":10}"
            );

            ArgumentCaptor<Employee> savedCaptor =
             ArgumentCaptor.forClass(Employee.class);

            verify(employeeRepository).save(savedCaptor.capture());
            assertTrue(savedCaptor.getValue().name.equals("name"));
            assertTrue(savedCaptor.getValue().email.equals("email"));
            assertTrue(savedCaptor.getValue().age == agePram);

        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            assertTrue(false);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
