package org.example.hotelmanagementbackend.Services;

import org.example.hotelmanagementbackend.DTOs.PeopleDTOMapper;
import org.example.hotelmanagementbackend.DTOs.PeopleInDTO;
import org.example.hotelmanagementbackend.DTOs.PeopleOutDTO;
import org.example.hotelmanagementbackend.Entities.People;
import org.example.hotelmanagementbackend.Exceptions.ApiRequestException;
import org.example.hotelmanagementbackend.Repositories.BookingRepository;
import org.example.hotelmanagementbackend.Repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private BookingRepository bookingRepository;
    private final PasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    public PeopleOutDTO addPeople(PeopleInDTO peopleInDTO) {
        People people = new People();
        people.setEmail(peopleInDTO.getEmail());
        people.setPassword(passwordEncoder.encode(peopleInDTO.getPassword()));
        people.setTelephone(peopleInDTO.getTelephone());
        people.setPeopleCategory(peopleInDTO.getPeopleCategory());
        return PeopleDTOMapper.apply(peopleRepository.save(people));
    }
    public List<PeopleOutDTO> getAllPeople(){
        return PeopleDTOMapper.apply(peopleRepository.findAll());
    }

    public PeopleOutDTO getPeople(String id){
        return PeopleDTOMapper.apply(peopleRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("People not found")));
    }

    public PeopleOutDTO updatePeople(PeopleInDTO peopleDTO){
        People people = peopleRepository.findById(peopleDTO.getPeopleId())
                .orElseThrow(() -> new ApiRequestException("People not found"));
        people.setPeopleCategory(peopleDTO.getPeopleCategory());
        people.setTelephone(peopleDTO.getPeopleId());
        people.setEmail(peopleDTO.getEmail());
        if(people.getPassword()!= null){
            people.setPassword(people.getPassword());
        }
        return PeopleDTOMapper.apply(peopleRepository.save(people));
    }

    public String deletePeople(String id){
        People people = peopleRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("People not found"));
        bookingRepository.deleteAll(people.getBookings());
        peopleRepository.delete(people);
        return id;
    }

    public PeopleOutDTO findUserByEmail(PeopleInDTO peopleInDTO){
        People people = peopleRepository.findPeopleByEmail(peopleInDTO.getEmail());
        return PeopleDTOMapper.apply(people);
    }

}
