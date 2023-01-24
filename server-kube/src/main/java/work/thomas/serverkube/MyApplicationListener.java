package work.thomas.serverkube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
@Order(0)
class MyApplicationListener
        implements ApplicationListener<ApplicationReadyEvent> {

    /** let's user access database somehow. */
    @Autowired
    EmployeeRepository employeeRepo;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        Faker faker = new Faker();
        String name;
        String email;
        int age;

        final int genAmount = 6;
        final int minAge = 10;
        final int maxAge = 100;
        for (int i = 0; i < genAmount; i++) {
            name = faker.name().firstName();
            email = faker.internet().emailAddress();
            age = faker.random().nextInt(minAge, maxAge);
            employeeRepo.save(new Employee(name, email, age));
        }
    }

}
