package org.example.hotelmanagementbackend.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.hotelmanagementbackend.DTOs.PeopleInDTO;
import org.example.hotelmanagementbackend.DTOs.PeopleOutDTO;
import org.example.hotelmanagementbackend.Services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> login(@RequestBody PeopleInDTO people, HttpServletResponse response, HttpServletRequest request){

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(people.getEmail(), people.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            HttpSession session = request.getSession(true); // Create a new session if none exists
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
            return ResponseEntity.ok(peopleService.findUserByEmail(people));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed!");
        }
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
