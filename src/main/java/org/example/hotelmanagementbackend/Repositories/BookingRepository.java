package org.example.hotelmanagementbackend.Repositories;

import org.example.hotelmanagementbackend.Entities.Bedroom;
import org.example.hotelmanagementbackend.Entities.Booking;
import org.example.hotelmanagementbackend.Entities.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findBookingsByClientEquals(People people);
    List<Booking> findBookingsByBedroomEquals(Bedroom bedroom);
}
