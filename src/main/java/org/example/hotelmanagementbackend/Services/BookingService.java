package org.example.hotelmanagementbackend.Services;

import org.example.hotelmanagementbackend.DTOs.BookingDTO;
import org.example.hotelmanagementbackend.DTOs.BookingDTOMapper;
import org.example.hotelmanagementbackend.Entities.*;
import org.example.hotelmanagementbackend.Exceptions.ApiRequestException;
import org.example.hotelmanagementbackend.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BedroomRepository bedroomRepository;
    @Autowired
    private AccommodationRepository accommodationRepository;
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private BillingRepository billingRepository;

    public BookingDTO addBooking(BookingDTO bookingDTO){
        Booking booking = new Booking();
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setEndDate(bookingDTO.getEndDate());
        booking.setBedroom(bedroomRepository.findById(bookingDTO.getBedroomId())
                .orElseThrow(() -> new ApiRequestException("Cannot find bedroom with id: " + bookingDTO.getBedroomId())));
        booking.setClient(peopleRepository.findById(bookingDTO.getPeopleId())
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + bookingDTO.getPeopleId())));
        List<Accommodation> accommodations = bookingDTO.getAccommodationIds().stream().map(
                m->accommodationRepository.findById(m)
                        .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + bookingDTO.getBedroomId())
                )).toList();
        booking.setAccomodations(accommodations);
        float price = 0;
        for(Accommodation acc: accommodations){
            price+=acc.getPrice();
        }
        Billing billing = new Billing();
        billing.setAmount(price);
        billing.setBillingDate(new Date());
        Billing billingSaved = billingRepository.save(billing);
        booking.setBilling(billingSaved);

//        Set<Integer> hey = new HashSet<>(Set.of(1, 2, 3, 4, 5));
//        Set<Integer> a = hey.stream().map(m->m+1).collect(Collectors.toSet());
//        a.add(5);
//        hey.s
        return BookingDTOMapper.apply(bookingRepository.save(booking));
    }

    public List<BookingDTO> getAllBookings(){
        return BookingDTOMapper.apply(bookingRepository.findAll());
    }
    public BookingDTO getBooking(int id){
        return BookingDTOMapper.apply(bookingRepository.findById(id)
                                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + id)));
    }

    public List<BookingDTO> getPeopleBookings(String peopleId){
        People people = peopleRepository.findById(peopleId)
                                        .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + peopleId));
        List<Booking> bookings = bookingRepository.findBookingsByClientEquals(people);
        return BookingDTOMapper.apply(bookings);
    }

    public List<BookingDTO> getBedroomBookings(int bedroomId){
        Bedroom bedroom = bedroomRepository.findById(bedroomId)
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + bedroomId));
        List<Booking> bookings = bookingRepository.findBookingsByBedroomEquals(bedroom);
        return BookingDTOMapper.apply(bookings);
    }

    public BookingDTO updateBooking (BookingDTO bookingDTO){
        Booking booking = bookingRepository.findById(bookingDTO.getBookingID())
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + bookingDTO.getBookingID()));
        Billing billing = billingRepository.findBillingByBookingEquals(booking);
        booking.setStatus(Boolean.TRUE);
        booking.setEndDate(bookingDTO.getEndDate());
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setBedroom(bedroomRepository.findById(bookingDTO.getBedroomId())
                .orElseThrow(() -> new ApiRequestException("Cannot find bedroom with id: " + bookingDTO.getBedroomId())));
        booking.setClient(peopleRepository.findById(bookingDTO.getPeopleId())
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + bookingDTO.getPeopleId())));
        List<Accommodation> accommodations = bookingDTO.getAccommodationIds().stream().map(
                m->accommodationRepository.findById(m)
                        .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + bookingDTO.getBedroomId())
                        )).toList();
        booking.setAccomodations(accommodations);
        float price = 0;
        for(Accommodation acc: accommodations){
            price+=acc.getPrice();
        }
        billing.setAmount(price);
        billingRepository.save(billing);
        return BookingDTOMapper.apply(bookingRepository.save(booking));
    }
}
