package org.example.hotelmanagementbackend.Services;

import org.example.hotelmanagementbackend.Entities.Billing;
import org.example.hotelmanagementbackend.Repositories.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {
    @Autowired
    private BillingRepository billingRepository;

    public Billing addBilling(Billing billing){
        return billingRepository.save(billing);
    }
    public List<Billing> getAllBillings(){
        return billingRepository.findAll();
    }
}
