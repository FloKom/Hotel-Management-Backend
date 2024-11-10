package org.example.hotelmanagementbackend.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotelmanagementbackend.Entities.TypeUser;

@Data @AllArgsConstructor @NoArgsConstructor
public class PeopleDTO {
    private String peopleId;
    private TypeUser peopleCategory;
    private String email;
    private String password;
    private String telephone;
}