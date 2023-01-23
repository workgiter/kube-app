package work.thomas.serverkube;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("Employee")
public class Employee {
    /**
     * unique id for data.
     */
    @Id
    private String id;

    /** name of employee. */
    private String name;
    /** email of the employee. */
    private String email;
    /** age of the emplyee. */
    private int age;

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
