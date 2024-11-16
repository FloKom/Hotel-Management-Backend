package org.example.hotelmanagementbackend.DTOs;

import org.example.hotelmanagementbackend.Entities.Bedroom;
import org.example.hotelmanagementbackend.Entities.Image;

import java.util.List;
import java.util.stream.Collectors;

public class BedroomDTOMapper {
    public static BedroomDTO apply(Bedroom bedroom) {
        BedroomDTO bedroomDTO = new BedroomDTO();

        bedroomDTO.setBedroomId(bedroom.getBedroomId());
        bedroomDTO.setDescription(bedroom.getDescription());
        bedroomDTO.setPrice(bedroom.getPrice());
        bedroomDTO.setBedroomName(bedroom.getBedroomName());
        bedroomDTO.setStatus(bedroom.getStatus());
//        bedroomDTO.setUrlPhoto(bedroom.getUrlPhoto());
        if(bedroom.getImages() != null) {
            bedroomDTO.setImageIds(bedroom.getImages().stream().map(Image::getImageId).toList());
        }
        bedroomDTO.setStatus(bedroom.getStatus());
        bedroomDTO.setStanding(bedroom.getStanding());
        bedroomDTO.setBedroomCategoryId(bedroom.getCategory().getBedroomCategoryId());
        return bedroomDTO;
    }

    public static List<BedroomDTO> apply(List<Bedroom> bedrooms) {
        return bedrooms.stream().map(BedroomDTOMapper::apply).collect(Collectors.toList());
    }
}
