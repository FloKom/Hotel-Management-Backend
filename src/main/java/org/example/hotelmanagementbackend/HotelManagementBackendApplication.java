package org.example.hotelmanagementbackend;

import org.example.hotelmanagementbackend.Entities.People;
import org.example.hotelmanagementbackend.Entities.TypeUser;
import org.example.hotelmanagementbackend.Repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HotelManagementBackendApplication {
	@Autowired
	private PeopleRepository peopleRepository;
	@GetMapping("hello")
	public String getHelloWorld() {

		return "Hello World";
	}


	public static void main(String[] args) {SpringApplication.run(HotelManagementBackendApplication.class, args);}

	@Bean
	CommandLineRunner start(){
		PasswordEncoder pass = new BCryptPasswordEncoder();
		People people = new People();
		people.setEmail("hello");
		people.setPassword(pass.encode("hello"));
		people.setTelephone("07 77 65 89 78");
		people.setPeopleCategory(TypeUser.CLIENT);
		return args -> {
			peopleRepository.save(
					people
			);
		};
	}

}
