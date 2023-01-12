package work.thomas.serverkube;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

public class Employees {

    public ArrayList<Employee> employees = new ArrayList<>();

    Employees(List<Employee> employeeList) {
        // Faker faker = new Faker();
        String name;
        String email;
        int age;

        for (int i = 0; i < employeeList.size(); i++) {
            // name = faker.name().firstName();
            // email = faker.internet().emailAddress();
            // age = faker.random().nextInt(10, 100);
            name = employeeList.get(i).name;
            email = employeeList.get(i).email;
            age = employeeList.get(i).age;
            employees.add(new Employee(name, email, age));
        }
    }
}
