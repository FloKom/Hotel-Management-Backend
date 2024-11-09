package org.example.hotelmanagementbackend.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Data  @AllArgsConstructor @NoArgsConstructor
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accommodationId;
    private String accommodationName;
    private String description;
    @ManyToMany
    private List<Booking> bookings;
    private float price;
}
