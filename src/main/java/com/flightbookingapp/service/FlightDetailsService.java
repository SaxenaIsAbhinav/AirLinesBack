package com.flightbookingapp.service;

import com.flightbookingapp.entity.FlightDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightDetailsService {
    List<FlightDetails> getFlightsByRoute(String origin, String destination);

    String postFlightDetails(List<FlightDetails> flightDetails);
}
