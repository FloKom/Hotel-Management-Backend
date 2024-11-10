package org.example.hotelmanagementbackend.Controllers;

import org.example.hotelmanagementbackend.DTOs.AccommodationDTO;
import org.example.hotelmanagementbackend.Services.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accommodation")
@CrossOrigin(origins = "*")
public class AccomodationController {
    @Autowired
    private AccommodationService accommodationService;

    @GetMapping("")
    public List<AccommodationDTO> getAllAccommodation() {
        return accommodationService.getAllAccommodations();
    }

    @GetMapping("/{id}")
    public AccommodationDTO getAccommodationById(@PathVariable int id) {
        return accommodationService.getAccommodationById(id);
    }

    @PostMapping("")
    public AccommodationDTO addAccommodation(@RequestBody AccommodationDTO accommodationDTO) {
        return accommodationService.addAccommodation(accommodationDTO);
    }

    @DeleteMapping("/{id}")
    public int deleteAccommodationById(@PathVariable int id) {
        return accommodationService.deleteAccommodation(id);
    }

    @PutMapping("/")
    public AccommodationDTO updateAccommodation(@RequestBody AccommodationDTO accommodationDTO) {
        return accommodationService.updateAccommodation(accommodationDTO);
    }
}
