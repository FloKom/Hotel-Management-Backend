package org.example.hotelmanagementbackend.Services;

import org.example.hotelmanagementbackend.DTOs.PeopleInDTO;
import org.example.hotelmanagementbackend.DTOs.PeopleOutDTO;
import org.example.hotelmanagementbackend.Entities.People;
import org.example.hotelmanagementbackend.Repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;
//    public PeopleOutDTO addPeople(PeopleInDTO peopleInDTO) {
//        People people = new People();
//        people.setEmail(peopleInDTO.getEmail());
//        people.setPassword(peopleInDTO.getPassword());
//        return peopleRepository.save(people);
//    }
}
