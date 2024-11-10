package org.example.hotelmanagementbackend.Controllers;

import org.example.hotelmanagementbackend.DTOs.BillingDTO;
import org.example.hotelmanagementbackend.Services.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {
    @Autowired
    private BillingService billingService;

    @GetMapping("")
    public List<BillingDTO> getAllBillings(){
        return billingService.getAllBillings();
    }

    @GetMapping("/{id}")
    public BillingDTO getBillingById(@PathVariable int id){
        return billingService.getBillingById(id);
    }

}
