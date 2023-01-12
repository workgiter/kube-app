package work.thomas.serverkube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.javafaker.Faker;

@SpringBootApplication
@EnableMongoRepositories
public class ServerKubeApplication {

	@Autowired
	EmployeeRepository employeeRepo;

	public static void main(String[] args) {
		SpringApplication.run(ServerKubeApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// Faker faker = new Faker();
	// String name;
	// String email;
	// int age;
	// for (int i = 0; i < 40; i++) {
	// name = faker.name().firstName();
	// email = faker.internet().emailAddress();
	// age = faker.random().nextInt(10, 100);
	// employeeRepo.save(new Employee(name, email, age));
	// }

	// }

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
