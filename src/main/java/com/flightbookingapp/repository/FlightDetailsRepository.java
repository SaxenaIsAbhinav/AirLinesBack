package com.flightbookingapp.repository;

import com.flightbookingapp.entity.FlightDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Integer> {

    @Query(value = "SELECT * FROM Flight_Details WHERE origin = :origin AND destination = :destination", nativeQuery = true)
    List<FlightDetails> findByOriginAndDestination(@Param("origin") String origin,
                                                   @Param("destination") String destination);


}
