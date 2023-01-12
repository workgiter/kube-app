package work.thomas.serverkube;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Employee")
public class Employee {
    @Id
    private String id;

    public String name;
    public String email;
    public int age;

    Employee(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, name='%s', email='%s, age=%s']",
                id, name, email, Integer.toString(age));
    }
}
