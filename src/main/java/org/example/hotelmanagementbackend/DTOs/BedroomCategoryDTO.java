package org.example.hotelmanagementbackend.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedroomCategoryDTO {
    private int bedroomCategoryId;
    private String BedroomCategoryName;
    private String Description;
}
