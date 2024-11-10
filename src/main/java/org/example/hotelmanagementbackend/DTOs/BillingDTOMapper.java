package org.example.hotelmanagementbackend.DTOs;

import org.example.hotelmanagementbackend.Entities.Billing;

import java.util.List;
import java.util.stream.Collectors;

public class BillingDTOMapper {
    public static BillingDTO apply(Billing billing) {
        BillingDTO billingDTO = new BillingDTO();
        billingDTO.setBillingId(billing.getBillingId());
        billingDTO.setBillingDate(billing.getBillingDate());
        billingDTO.setAmount(billing.getAmount());
        return billingDTO;
    }

    public static List<BillingDTO> apply(List<Billing> billings) {
        return billings.stream().map(BillingDTOMapper::apply).collect(Collectors.toList());
    }
}
