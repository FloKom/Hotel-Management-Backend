package org.example.hotelmanagementbackend.DTOs;

//import org.example.hotelmanagementbackend.Entities.people;
import org.example.hotelmanagementbackend.Entities.People;

import java.util.List;
import java.util.stream.Collectors;

public class PeopleDTOMapper {
    public static PeopleOutDTO apply(People people) {
        PeopleOutDTO peopleDTO = new PeopleOutDTO();
        peopleDTO.setPeopleId(people.getPeopleId());
        peopleDTO.setEmail(people.getEmail());
        peopleDTO.setUsername(people.getUsername());
        peopleDTO.setTelephone(people.getTelephone());
        peopleDTO.setPeopleCategory(people.getPeopleCategory());
        return peopleDTO;
    }

    public static List<PeopleOutDTO> apply(List<People> peoples) {
        return peoples.stream().map(PeopleDTOMapper::apply).collect(Collectors.toList());
    }
}
