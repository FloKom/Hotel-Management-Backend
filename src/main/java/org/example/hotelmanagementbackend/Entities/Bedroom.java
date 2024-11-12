package org.example.hotelmanagementbackend.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Bedroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bedroomId;
    private RoomStatus status;
    @OneToMany(mappedBy = "bedroom")
    private List<Image> images;
    private String standing;
    private String description;
    private String bedroomName;
    private float price;
    @OneToMany(mappedBy = "bedroom")
    private List<Booking> bookings;
    @ManyToOne
    private BedroomCategory category;
}
