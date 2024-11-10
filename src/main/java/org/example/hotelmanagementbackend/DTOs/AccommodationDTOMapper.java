package org.example.hotelmanagementbackend.DTOs;

import org.example.hotelmanagementbackend.Entities.Accommodation;

import java.util.List;
import java.util.stream.Collectors;

public class AccommodationDTOMapper {
    public static AccommodationDTO apply(Accommodation accommodation) {
        AccommodationDTO accommodationDTO = new AccommodationDTO();

        accommodationDTO.setAccommodationId(accommodation.getAccommodationId());
        accommodationDTO.setDescription(accommodation.getDescription());
        accommodationDTO.setPrice(accommodation.getPrice());
        accommodationDTO.setAccommodationName(accommodation.getAccommodationName());
        return accommodationDTO;
    }

    public static List<AccommodationDTO> apply(List<Accommodation> accommodations) {
        return accommodations.stream().map(AccommodationDTOMapper::apply).collect(Collectors.toList());
    }
}
