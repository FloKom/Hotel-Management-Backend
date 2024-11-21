package org.example.hotelmanagementbackend.DTOs;

import org.example.hotelmanagementbackend.Entities.BedroomCategory;

import java.util.List;
import java.util.stream.Collectors;

public class BedroomCategoryDTOMapper {
    public static BedroomCategoryDTO apply(BedroomCategory bedroomCategory) {
        BedroomCategoryDTO bedroomCategoryDTO = new BedroomCategoryDTO();
        bedroomCategoryDTO.setBedroomCategoryId(bedroomCategory.getBedroomCategoryId());
        bedroomCategoryDTO.setBedroomCategoryName(bedroomCategory.getBedroomCategoryName());
        bedroomCategoryDTO.setDescription(bedroomCategory.getDescription());
        bedroomCategoryDTO.setBedroomCategoryName(bedroomCategory.getBedroomCategoryName());
        return bedroomCategoryDTO;
    }

    public static List<BedroomCategoryDTO> apply(List<BedroomCategory> bedroomCategories) {
        return bedroomCategories.stream().map(BedroomCategoryDTOMapper::apply).collect(Collectors.toList());
    }
}
