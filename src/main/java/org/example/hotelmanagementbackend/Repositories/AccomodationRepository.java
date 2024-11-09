package org.example.hotelmanagementbackend.Repositories;

import org.example.hotelmanagementbackend.Entities.Accomodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationRepository extends JpaRepository<Accomodation, Integer> {

}
