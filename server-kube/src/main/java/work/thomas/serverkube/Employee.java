package work.thomas.serverkube;

import com.github.javafaker.*;

public class Employee {
    public String name;
    public String email;
    public int age;

    Employee() {
        Faker faker = new Faker();
        this.name = faker.name().firstName();
        this.email = faker.internet().emailAddress();
        this.age = faker.random().nextInt(10, 100);
    }

}
