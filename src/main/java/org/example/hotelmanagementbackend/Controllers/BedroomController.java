package org.example.hotelmanagementbackend.Controllers;

import org.example.hotelmanagementbackend.DTOs.BedroomDTO;
import org.example.hotelmanagementbackend.Services.BedroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bedroom")
public class BedroomController {
    @Autowired
    private BedroomService bedroomService;

    @GetMapping("/{id}")
    public BedroomDTO getBedroomById(@PathVariable int id) {
        return bedroomService.findBedroomById(id);
    }

    @GetMapping("")
    public List<BedroomDTO> getAllBedrooms() {
        return bedroomService.getAllBedrooms();
    }

    @PostMapping("")
    public BedroomDTO addBedroom(@RequestBody BedroomDTO bedroomDTO) {
        return bedroomService.addBedroom(bedroomDTO);
    }

    @DeleteMapping("/{id}")
    public int deleteBedroom(@PathVariable int id) {
        return bedroomService.deleteBedroom(id);
    }

    @PutMapping
    public BedroomDTO updateBedroom(@RequestBody BedroomDTO bedroomDTO) {
        return bedroomService.updateBedroom(bedroomDTO);
    }

    @GetMapping("/category/{id}")
    public List<BedroomDTO> getBedroomByCategory(@PathVariable int id){
        return bedroomService.getAllBedroomsByCategory(id);
    }

}
