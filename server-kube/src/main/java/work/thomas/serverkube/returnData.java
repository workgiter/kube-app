package work.thomas.serverkube;

// import java.net.URI;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.github.javafaker.*;

@RestController
@RequestMapping(path = "/people")
public class returnData {

    @GetMapping(path = "/", produces = "application/json")
    public String[] NamesGET() {
        Faker faker = new Faker();
        String[] myarray = new String[40];
        for (int i = 0; i < myarray.length; i++) {
            myarray[i] = faker.name().fullName();
            ;
        }
        return myarray;
        // return "alex, bob, cat, david, ethan";
    }

}
