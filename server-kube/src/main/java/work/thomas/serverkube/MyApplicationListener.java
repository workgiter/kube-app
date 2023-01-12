package work.thomas.serverkube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
@Order(0)
class MyApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    EmployeeRepository employeeRepo;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // TODO Auto-generated method stub
        Faker faker = new Faker();
        String name;
        String email;
        int age;
        for (int i = 0; i < 6; i++) {
            name = faker.name().firstName();
            email = faker.internet().emailAddress();
            age = faker.random().nextInt(10, 100);
            employeeRepo.save(new Employee(name, email, age));
        }
    }

}