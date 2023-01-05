package work.thomas.serverkube;

import java.util.ArrayList;

public class Employees {

    public ArrayList<Employee> employees = new ArrayList<>();

    Employees() {
        for (int i = 0; i < 40; i++) {
            employees.add(new Employee());
        }
    }
}
