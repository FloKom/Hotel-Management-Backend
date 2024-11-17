package org.example.hotelmanagementbackend.Services;

import org.example.hotelmanagementbackend.Entities.People;
import org.example.hotelmanagementbackend.Repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        People people = peopleRepository.findPeopleByEmail(email);
        if (people == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User
                .withUsername(people.getEmail())
                .password(people.getPassword())
                .roles(String.valueOf(people.getPeopleCategory()))
                .build();
    }
}
