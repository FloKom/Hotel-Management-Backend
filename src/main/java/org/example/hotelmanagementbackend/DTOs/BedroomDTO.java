package org.example.hotelmanagementbackend.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotelmanagementbackend.Entities.RoomStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedroomDTO {
    private int bedroomId;
    private RoomStatus status;
    private String urlPhoto;
    private String standing;
    private String description;
    private String bedroomName;
    private float price;
}
