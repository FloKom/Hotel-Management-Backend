package org.example.hotelmanagementbackend.Controllers;

import org.example.hotelmanagementbackend.DTOs.PeopleInDTO;
import org.example.hotelmanagementbackend.DTOs.PeopleOutDTO;
import org.example.hotelmanagementbackend.Services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    PeopleService peopleService;

    @GetMapping("")
    public List<PeopleOutDTO> findAllPeoples(){
        return peopleService.getAllPeople();
    }

    @GetMapping("/{id}")
    public PeopleOutDTO findPeople(@PathVariable String id){
        return peopleService.getPeople(id);
    }

    @PostMapping
    public PeopleOutDTO addPeople (@RequestBody PeopleInDTO people){
        return peopleService.addPeople(people);
    }

    @PutMapping("/{id}")
    public PeopleOutDTO updatePeople(PeopleInDTO people){
        return peopleService.updatePeople(people);
    }

    @DeleteMapping
    public String deletePeople(String id){
        return peopleService.deletePeople(id);
    }
}
