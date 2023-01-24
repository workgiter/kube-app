package work.thomas.serverkube;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    /**
     * return employee from database with given name.
     *
     * @param name
     * @return employee data
     */
    @Query("{name:'?0'}")
    Employee findItemByName(String name);

    /**
     * return all employess with name.
     *
     * @param name
     * @return list of employees
     */
    @Query(value = "{name:'?0'}", fields = "{'email' : 1, 'age' : 1}")
    List<Employee> findAll(String name);

    /**
     * count enteries.
     *
     * @return number
     */
    long count();

    /**deletes employee with given id.
     * @param id id of employee
     */
    void deleteById(String id);
}
