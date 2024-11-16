package org.example.hotelmanagementbackend.Repositories;

import org.example.hotelmanagementbackend.Entities.Booking;
import org.example.hotelmanagementbackend.Entities.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<People, String> {
    People findPeopleByEmail(String email);
}
