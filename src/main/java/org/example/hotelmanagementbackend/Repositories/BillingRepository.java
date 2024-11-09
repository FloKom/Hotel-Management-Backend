package org.example.hotelmanagementbackend.Repositories;

import org.example.hotelmanagementbackend.Entities.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {

}
