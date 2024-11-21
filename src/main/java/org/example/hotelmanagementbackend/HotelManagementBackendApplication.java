package org.example.hotelmanagementbackend;

import org.example.hotelmanagementbackend.Entities.*;
import org.example.hotelmanagementbackend.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class HotelManagementBackendApplication {
	@Autowired
	private AccommodationRepository accommodationRepository;
	@Autowired
	private PeopleRepository peopleRepository;
	@Autowired
	private BedroomCategoryRepository bedroomCategoryRepository;
	@Autowired
	private BedroomRepository bedroomRepository;
	@Autowired
	private ImageRepository imageRepository;
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
		BedroomCategory bedroomCategory = new BedroomCategory();
		bedroomCategory.setBedroomCategoryName("Hello");
		bedroomCategory.setDescription("category cool");
		Bedroom bedroom = new Bedroom();
		bedroom.setBedroomName("Bedroom");
		bedroom.setDescription("description cool");
		bedroom.setCategory(bedroomCategory);
		List<Image> imgs = new ArrayList<Image>();
		Image img = new Image();
		img.setImageId("7b491644-1929-4840-90fa-c1ebca8a071b_Capture3.PNG");
		img.setBedroom(bedroom);
		imgs.add(img);
		Image img1 = new Image();
		img1.setBedroom(bedroom);
		img1.setImageId("21acd45c-69ca-4568-9068-b1eb88d64898_Capture1.PNG");
		imgs.add(img1);
		Image img2 = new Image();
		img2.setBedroom(bedroom);
		img2.setImageId("485f2192-2e0f-4bb3-b645-cbcf5cabe9f6_Capture1.PNG");
		imgs.add(img2);
		Accommodation accommodation = new Accommodation();
		accommodation.setDescription("description cool");
		accommodation.setAccommodationName("sweep the floor");
		accommodation.setPrice(50);
		Accommodation accommodation1 = new Accommodation();
		accommodation1.setDescription("description cool");
		accommodation1.setAccommodationName("Repassage");
		accommodation1.setPrice(40);
		return args -> {
			peopleRepository.save(people);
			bedroomCategoryRepository.save(bedroomCategory);
			bedroomRepository.save(bedroom);
			imageRepository.saveAll(imgs);
			accommodationRepository.save(accommodation);
			accommodationRepository.save(accommodation1);
		};
	}

}
