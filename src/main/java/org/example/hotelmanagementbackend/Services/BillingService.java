package org.example.hotelmanagementbackend.Services;

import org.example.hotelmanagementbackend.DTOs.BillingDTO;
import org.example.hotelmanagementbackend.DTOs.BillingDTOMapper;
import org.example.hotelmanagementbackend.Entities.Billing;
import org.example.hotelmanagementbackend.Exceptions.ApiRequestException;
import org.example.hotelmanagementbackend.Repositories.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {
    @Autowired
    private BillingRepository billingRepository;

//    public BillingDTO addBilling(BillingDTO billingDTO){
//        Billing billing = new Billing();
//        billing.setBillingDate(billingDTO.getBillingDate());
//        billing.
//        return billingRepository.save(billing);
//    }
    public List<BillingDTO> getAllBillings(){
        return BillingDTOMapper.apply(billingRepository.findAll());
    }
    public BillingDTO getBillingById(int id){
        return BillingDTOMapper.apply(billingRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Cannot find Person with id: " + id)));
    }
}
