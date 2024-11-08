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
    private String peopleId;
//    @Column(name="Cat")
    private TypeUser peopleCategory;
    private String email;
    private String password;
    @OneToMany(mappedBy = "client")
    private List<Booking> booking;

}
