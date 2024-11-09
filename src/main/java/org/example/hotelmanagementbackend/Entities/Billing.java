package org.example.hotelmanagementbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billingId;
    @OneToOne
    private Booking booking;
    @Temporal(TemporalType.DATE)
    private Date billingDate;
    private float amount;
}
