package org.example.hotelmanagementbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BedroomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bedroomCategoryId;
    private String bedroomCategoryName;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Bedroom> bedrooms;
}
