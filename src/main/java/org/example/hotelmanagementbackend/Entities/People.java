package org.example.hotelmanagementbackend.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class People {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String peopleId;
    private TypeUser peopleCategory;
    private String email;
    private String password;
    private String telephone;
    private String username;
    @OneToMany(mappedBy = "client")
    private List<Booking> bookings;

}
