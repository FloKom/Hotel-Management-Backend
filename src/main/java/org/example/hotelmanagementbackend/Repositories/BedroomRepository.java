package org.example.hotelmanagementbackend.Repositories;

import org.example.hotelmanagementbackend.Entities.Bedroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedroomRepository extends JpaRepository<Bedroom, Integer> {

}
