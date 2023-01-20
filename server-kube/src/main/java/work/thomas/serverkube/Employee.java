package work.thomas.serverkube;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Employee")
public class Employee {
    /**
     * unique id for data.
     */
    @Id
    public String id;

    /** name of employee. */
    public String name;
    /** email of the employee. */
    public String email;
    /** age of the emplyee. */
    public int age;

    Employee() {
    }

    Employee(final String namePram, final String emailPram,
            final int agePram) {
        this.name = namePram;
        this.email = emailPram;
        this.age = agePram;
    }

    @Override
    public final String toString() {
        return String.format(
                "Customer[id=%s, name='%s', email='%s, age=%s']",
                id, name, email, Integer.toString(age));
    }
}
