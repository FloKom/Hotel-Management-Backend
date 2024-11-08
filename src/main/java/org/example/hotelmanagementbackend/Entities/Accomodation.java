package org.example.hotelmanagementbackend.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Data  @AllArgsConstructor @NoArgsConstructor
public class Accomodation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String hotelServiceId;
    private String serviceName;
    @ManyToMany
    private List<Booking> bookings;
}
