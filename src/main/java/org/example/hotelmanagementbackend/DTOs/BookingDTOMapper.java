package org.example.hotelmanagementbackend.DTOs;

import org.example.hotelmanagementbackend.Entities.Accommodation;
import org.example.hotelmanagementbackend.Entities.Booking;

import java.util.List;
import java.util.stream.Collectors;

public class BookingDTOMapper {
    public static BookingDTO apply(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setBookingID(booking.getBookingID());
        bookingDTO.setStartDate(booking.getStartDate());
        bookingDTO.setEndDate(booking.getEndDate());
        bookingDTO.setStatus(booking.getStatus());
        bookingDTO.setPeopleId(booking.getClient().getPeopleId());
        bookingDTO.setBedroomId(booking.getBedroom().getBedroomId());
        bookingDTO.setAccommodationIds(booking.getAccomodations().stream().map(Accommodation::getAccommodationId).collect(Collectors.toList()));
        return bookingDTO;
    }

    public static List<BookingDTO> apply(List<Booking> bookings) {
        return bookings.stream().map(BookingDTOMapper::apply).collect(Collectors.toList());
    }
}
