package work.thomas.serverkube;

import java.util.ArrayList;
import java.util.List;

public class Employees {

    /** array list of employees. */
    public List<Employee> employees = new ArrayList<>();

    Employees(final List<Employee> employeeList) {
        this.employees = employeeList;
    }

}
