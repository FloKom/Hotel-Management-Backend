package org.example.hotelmanagementbackend.Services;

import jakarta.transaction.Transactional;
import org.example.hotelmanagementbackend.DTOs.BedroomDTO;
import org.example.hotelmanagementbackend.DTOs.BedroomDTOMapper;
import org.example.hotelmanagementbackend.Entities.Accommodation;
import org.example.hotelmanagementbackend.Entities.Bedroom;
import org.example.hotelmanagementbackend.Exceptions.ApiRequestException;
import org.example.hotelmanagementbackend.Repositories.BedroomRepository;
import org.example.hotelmanagementbackend.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedroomService {

    @Autowired
    private BedroomRepository bedroomRepository;
    @Autowired
    private BookingRepository bookingRepository;
    public BedroomDTO addBedroom(BedroomDTO bedroomDTO) {
        Bedroom bedroom = new Bedroom();
        bedroom.setBedroomName(bedroomDTO.getBedroomName());
        bedroom.setPrice(bedroomDTO.getPrice());
        bedroom.setDescription(bedroomDTO.getDescription());
        bedroom.setStanding(bedroomDTO.getStanding());
        bedroom.setStatus(bedroomDTO.getStatus());
        bedroom.setUrlPhoto(bedroomDTO.getUrlPhoto());
        return BedroomDTOMapper.apply(bedroomRepository.save(bedroom));
    }

    public BedroomDTO updateBedroom(BedroomDTO bedroomDTO) {

        Bedroom bedroom = bedroomRepository.findById(bedroomDTO.getBedroomId())
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + bedroomDTO.getBedroomId()));
        bedroom.setBedroomName(bedroomDTO.getBedroomName());
        bedroom.setPrice(bedroomDTO.getPrice());
        bedroom.setDescription(bedroomDTO.getDescription());
        bedroom.setStanding(bedroomDTO.getStanding());
        bedroom.setStatus(bedroomDTO.getStatus());
        bedroom.setBedroomId(bedroomDTO.getBedroomId());
        bedroom.setUrlPhoto(bedroomDTO.getUrlPhoto());

        return BedroomDTOMapper.apply(bedroomRepository.save(bedroom));
    }

    public BedroomDTO findBedroomById(int bedroomId) {
        return BedroomDTOMapper.apply(bedroomRepository.findById(bedroomId)
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + bedroomId)));
    }

    public List<BedroomDTO> getAllBedrooms() {
        return BedroomDTOMapper.apply(bedroomRepository.findAll());
    }

    @Transactional
    public int deleteBedroom(int id) {
        Bedroom bedroom = bedroomRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + id));
        bookingRepository.deleteAll(bedroom.getBookings());
        bedroomRepository.deleteById(id);
        return id;
    }
}
