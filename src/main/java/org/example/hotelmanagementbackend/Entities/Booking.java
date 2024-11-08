package org.example.hotelmanagementbackend.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Date;

@Entity @Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    private int bookingID;
    private Date startDate;
    private Date endDate;
    @ManyToMany(mappedBy = "bookings")
    private List<Accomodation> accomodation;
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private People client;
    private Boolean status;
}
