package work.thomas.serverkube;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employees {

    /** list of employees. */
    private List<Employee> employees = new ArrayList<>();

    Employees(final List<Employee> employeeList) {
        this.employees = employeeList;
    }

}
