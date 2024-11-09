package org.example.hotelmanagementbackend.Services;

import jakarta.transaction.Transactional;
import org.example.hotelmanagementbackend.DTOs.AccommodationDTO;
import org.example.hotelmanagementbackend.DTOs.AccommodationDTOMapper;
import org.example.hotelmanagementbackend.Entities.Accommodation;
import org.example.hotelmanagementbackend.Exceptions.ApiRequestException;
import org.example.hotelmanagementbackend.Repositories.AccommodationRepository;
import org.example.hotelmanagementbackend.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationService {
    @Autowired
    private AccommodationRepository accommodationRepository;
    @Autowired
    private BookingRepository bookingRepository;
    public AccommodationDTO addAccommodation(AccommodationDTO accommodationDTO) {
        Accommodation accommodation = new Accommodation();
        accommodation.setDescription(accommodationDTO.getDescription());
        accommodation.setPrice(accommodationDTO.getPrice());
        accommodation.setAccommodationName(accommodationDTO.getAccommodationName());
        return AccommodationDTOMapper.apply(accommodationRepository.save(accommodation));
    }

    public List<AccommodationDTO> getAllAccommodations() {
        return AccommodationDTOMapper.apply(accommodationRepository.findAll());
    }
    public AccommodationDTO getAccommodationById(int id) {
        return AccommodationDTOMapper.apply(accommodationRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + id)));
    }
    public AccommodationDTO updateAccommodation(AccommodationDTO accommodationDTO) {

        Accommodation accommodation = accommodationRepository.findById(accommodationDTO.getAccommodationId())
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + accommodationDTO.getAccommodationId()));
        accommodation.setAccommodationName(accommodationDTO.getAccommodationName());
        accommodation.setDescription(accommodationDTO.getDescription());
        accommodation.setPrice(accommodationDTO.getPrice());
        return AccommodationDTOMapper.apply(accommodationRepository.save(accommodation));
    }

    @Transactional
    public int deleteAccommodation(int id) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + id));
        bookingRepository.deleteAll(accommodation.getBookings());
        accommodationRepository.deleteById(id);
        return id;
    }
}
