package work.thomas.serverkube;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    @Query("{name:'?0'}")
    public Employee findItemByName(String name);

    @Query(value = "{name:'?0'}", fields = "{'email' : 1, 'age' : 1}")
    public List<Employee> findAll(String name);

    public long count();
}
