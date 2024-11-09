package org.example.hotelmanagementbackend.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Date;

@Entity @Data  @AllArgsConstructor @NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingID;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private Boolean status;
    @ManyToMany(mappedBy = "bookings")
    private List<Accommodation> accomodations;
    @ManyToOne
    private People client;
    @ManyToOne
    private Bedroom bedroom;
    @OneToOne(mappedBy = "booking")
    private Billing billing;
}
