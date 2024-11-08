package org.example.hotelmanagementbackend;

import org.example.hotelmanagementbackend.Repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

}
