package org.example.hotelmanagementbackend.Repositories;

import org.example.hotelmanagementbackend.Entities.Booking;
import org.example.hotelmanagementbackend.Entities.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, String> {
    List<Booking> findBookingByPeopleId(People p);
}
