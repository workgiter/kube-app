package work.thomas.serverkube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ServerKubeApplication {
	/** interface to access database. */
	@Autowired
	EmployeeRepository employeeRepo;

	/**
	 * run server.
	 *
	 * @param args
	 */
	public static void main(final String[] args) {
		SpringApplication.run(ServerKubeApplication.class, args);
	}

}
