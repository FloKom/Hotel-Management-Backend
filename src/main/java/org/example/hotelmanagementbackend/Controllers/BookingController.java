package org.example.hotelmanagementbackend.Controllers;

import org.example.hotelmanagementbackend.DTOs.BookingDTO;
import org.example.hotelmanagementbackend.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("")
    public List<BookingDTO> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public BookingDTO getBooking(@PathVariable int id){
        return bookingService.getBooking(id);
    }
    @PostMapping("")
    public BookingDTO addBooking(@RequestBody BookingDTO booking){
        return bookingService.addBooking(booking);
    }

    @PutMapping
    public BookingDTO updateBooking(@RequestBody BookingDTO bookingDTO){
        return bookingService.updateBooking(bookingDTO);
    }
}
