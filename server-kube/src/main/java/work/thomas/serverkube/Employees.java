package work.thomas.serverkube;

import java.util.ArrayList;
import java.util.List;

public class Employees {

    /** array list of employees. */
    public ArrayList<Employee> employees = new ArrayList<>();

    Employees(final List<Employee> employeeList) {
        // Faker faker = new Faker();
        String name;
        String email;
        int age;

        for (int i = 0; i < employeeList.size(); i++) {
            name = employeeList.get(i).name;
            email = employeeList.get(i).email;
            age = employeeList.get(i).age;
            employees.add(new Employee(name, email, age));
        }
    }
}
