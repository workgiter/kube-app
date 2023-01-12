package work.thomas.serverkube;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ReturnData.class)
public class ReturnDataTest {
    @Autowired
    private MockMvc mockMvc;

    // @Test
    // public void givenHTTPRequest_whenGetEmployeeData_thenRespond() throws
    // Exception {
    // RequestBuilder requestBuilder = MockMvcRequestBuilders
    // .get("/people/")
    // .contentType("application/json");

    // MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

    // int actualResult = mvcResult.getResponse().getStatus();
    // int expectedResult = HttpStatus.OK.value();

    // Assertions.assertEquals(expectedResult, actualResult);
    // }

}
