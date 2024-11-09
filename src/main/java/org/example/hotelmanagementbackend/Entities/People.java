package org.example.hotelmanagementbackend.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String peopleId;
    private TypeUser peopleCategory;
    private String email;
    private String password;
    private String telephone;
    @OneToMany(mappedBy = "client")
    private List<Booking> bookings;

}
