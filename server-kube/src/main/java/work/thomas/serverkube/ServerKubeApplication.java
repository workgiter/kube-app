package work.thomas.serverkube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ServerKubeApplication {

	@Autowired
	EmployeeRepository employeeRepo;

	public static void main(String[] args) {

		SpringApplication.run(ServerKubeApplication.class, args);
	}

	// @Override
	// public void run(String... strings) throws Exception {
	// System.out.println("a");
	// }

	// public void test() {
	// System.out.println("Data creation started...");
	// employeeRepo.save(new Employee("Whole Wheat Biscuit", "Whole Wheat Biscuit",
	// 5));
	// employeeRepo.save(new Employee("Kodo Millet", "XYZ Kodo Millet healthy", 2));
	// employeeRepo.save(new Employee("Dried Red Chilli", "Dried Whole Red Chilli",
	// 2));
	// employeeRepo.save(new Employee("Pearl Millet", "Healthy Pearl Millet", 1));
	// employeeRepo.save(new Employee("Cheese Crackers", "Bonny Cheese Crackers
	// Plain", 6));
	// System.out.println("Data creation complete...");

	// }

}
