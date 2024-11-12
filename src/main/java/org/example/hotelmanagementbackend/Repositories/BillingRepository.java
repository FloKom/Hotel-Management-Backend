package org.example.hotelmanagementbackend.Repositories;

import org.example.hotelmanagementbackend.Entities.Billing;
import org.example.hotelmanagementbackend.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {
    Billing findBillingByBookingEquals(Booking booking);
}
