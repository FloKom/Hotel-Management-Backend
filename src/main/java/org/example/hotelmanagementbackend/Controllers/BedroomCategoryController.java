package org.example.hotelmanagementbackend.Controllers;

import org.example.hotelmanagementbackend.DTOs.BedroomCategoryDTO;
import org.example.hotelmanagementbackend.Services.BedroomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bedroomCategory")
public class BedroomCategoryController {

    @Autowired
    private BedroomCategoryService bedroomCategoryService;

    @GetMapping("")
    public List<BedroomCategoryDTO> getAllBedroomCategory() {
        return bedroomCategoryService.getAllBedroomCategories();
    }

    @GetMapping("/{id}")
    public BedroomCategoryDTO getBedroomCategoryById(@PathVariable int id) {
        return bedroomCategoryService.getBedroomCategoryById(id);
    }

    @PostMapping
    public BedroomCategoryDTO addBedroomCategory(@RequestBody BedroomCategoryDTO bedroomCategoryDTO) {
        return bedroomCategoryService.addBedroomCategory(bedroomCategoryDTO);
    }

    @PutMapping
    public BedroomCategoryDTO updateBedroomCategory(@RequestBody BedroomCategoryDTO bedroomCategoryDTO) {
        return bedroomCategoryService.updateBedroomCategory(bedroomCategoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBedroomCategory(@PathVariable int id) {
        bedroomCategoryService.deleteBedroomCategory(id);
    }
}
