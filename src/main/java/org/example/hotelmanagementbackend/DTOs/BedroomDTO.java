package org.example.hotelmanagementbackend.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotelmanagementbackend.Entities.RoomStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedroomDTO {
    private int bedroomId;
    private RoomStatus status;
    private List<String> imageIds;
    private String standing;
    private String description;
    private String bedroomName;
    private String bedroomCategoryName;
    private int bedroomCategoryId;
    private float price;
}
