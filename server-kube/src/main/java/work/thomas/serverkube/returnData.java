package work.thomas.serverkube;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import java.net.URI;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
// import com.github.javafaker.*;

@RestController
@RequestMapping(path = "/people")
@CrossOrigin(origins = "*")
public class ReturnData {
    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping(path = "/", produces = "application/json")
    public Employees NamesGET() {
        // Faker faker = new Faker();
        // System.out.println("Data creation started...");
        // employeeRepo.save(new Employee("Whole Wheat Biscuit", "Whole Wheat Biscuit",
        // 5));

        Employees data = new Employees(employeeRepo.findAll());
        // data = employeeRepo.findAll();
        return data; // data;
        // return "alex, bob, cat, david, ethan";
    }

}
