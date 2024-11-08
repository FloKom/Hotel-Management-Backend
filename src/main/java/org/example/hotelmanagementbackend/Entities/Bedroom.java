package org.example.hotelmanagementbackend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bedroom {
    @Id
    private int bedroomId;
    private RoomStatus status;
    private String url;
    private String standing;
}
