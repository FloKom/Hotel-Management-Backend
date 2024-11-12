package org.example.hotelmanagementbackend.Repositories;

import org.example.hotelmanagementbackend.Entities.Bedroom;
import org.example.hotelmanagementbackend.Entities.BedroomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BedroomRepository extends JpaRepository<Bedroom, Integer> {
    List<Bedroom> findBedroomsByCategoryEquals(BedroomCategory category);
}
