package org.example.hotelmanagementbackend.Controllers;

import org.example.hotelmanagementbackend.DTOs.PeopleInDTO;
import org.example.hotelmanagementbackend.DTOs.PeopleOutDTO;
import org.example.hotelmanagementbackend.Services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public PeopleController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

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

    @PostMapping("/login")
    public String login(@RequestBody PeopleInDTO people){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(people.getEmail(), people.getPassword())
        );

        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "User authenticated successfully!";
        }
        return "Authentication failed!";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
