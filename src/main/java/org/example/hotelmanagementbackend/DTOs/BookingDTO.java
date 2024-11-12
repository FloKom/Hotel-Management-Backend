package org.example.hotelmanagementbackend.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private int bookingID;
    private Date startDate;
    private Date endDate;
    private Boolean status;
    private String peopleId;
    private int bedroomId;
    private List<Integer> accommodationIds;
}
