package org.example.hotelmanagementbackend.Services;

import jakarta.transaction.Transactional;
import org.example.hotelmanagementbackend.DTOs.BedroomCategoryDTO;
import org.example.hotelmanagementbackend.DTOs.BedroomCategoryDTOMapper;
import org.example.hotelmanagementbackend.Entities.Bedroom;
import org.example.hotelmanagementbackend.Entities.BedroomCategory;
import org.example.hotelmanagementbackend.Exceptions.ApiRequestException;
import org.example.hotelmanagementbackend.Repositories.BedroomCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedroomCategoryService {
    @Autowired
    private BedroomCategoryRepository bedroomCategoryRepository;

    public BedroomCategoryDTO addBedroomCategory(BedroomCategoryDTO bedroomCategoryDTO) {
        BedroomCategory bedroomCategory = new BedroomCategory();
        bedroomCategory.setDescription(bedroomCategoryDTO.getDescription());
        bedroomCategory.setDescription(bedroomCategoryDTO.getDescription());
        bedroomCategory.setBedroomCategoryName(bedroomCategoryDTO.getBedroomCategoryName());
        return BedroomCategoryDTOMapper.apply(bedroomCategoryRepository.save(bedroomCategory));
    }
    public List<BedroomCategoryDTO> getAllBedroomCategories() {
        return BedroomCategoryDTOMapper.apply(bedroomCategoryRepository.findAll());
    }
    public BedroomCategoryDTO getBedroomCategoryById(int id) {
        return BedroomCategoryDTOMapper.apply(bedroomCategoryRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("BedroomCategory not found")));
    }

    public BedroomCategoryDTO updateBedroomCategory(BedroomCategoryDTO bedroomCategoryDTO) {
        BedroomCategory bedroomCategory = bedroomCategoryRepository.findById(bedroomCategoryDTO.getBedroomCategoryId())
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + bedroomCategoryDTO.getBedroomCategoryId()));
        bedroomCategory.setDescription(bedroomCategoryDTO.getDescription());
        bedroomCategory.setBedroomCategoryName(bedroomCategoryDTO.getBedroomCategoryName());
        return BedroomCategoryDTOMapper.apply(bedroomCategoryRepository.save(bedroomCategory));
    }

    @Transactional
    public int deleteBedroomCategory(int id) {
        BedroomCategory bedroom = bedroomCategoryRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + id));
        bedroomCategoryRepository.deleteById(id);
        return id;
    }
}

