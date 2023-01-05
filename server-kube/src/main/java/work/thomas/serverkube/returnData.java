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

@RestController
@RequestMapping(path = "/people")
public class returnData {

    @GetMapping(path = "/", produces = "application/json")
    public String[] NamesGET() {
        String[] myarray = new String[5];
        myarray[0] = "alex";
        myarray[1] = "bob";
        myarray[2] = "cat";
        myarray[3] = "david";
        myarray[4] = "ethan";
        return myarray;
        // return "alex, bob, cat, david, ethan";
    }

}
