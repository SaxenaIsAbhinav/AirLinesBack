package com.flightbookingapp.service.impl;

import com.flightbookingapp.entity.FlightDetails;
import com.flightbookingapp.repository.FlightDetailsRepository;
import com.flightbookingapp.service.FlightDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

    @Autowired
    private FlightDetailsRepository flightDetailsRepository;

    @Override
    public List<FlightDetails> getFlightsByRoute(String origin, String destination){
        return flightDetailsRepository.findByOriginAndDestination(origin, destination);

    }

    //   _________________________Save Profile Details_______________________________________________________

    public String postFlightDetails(List<FlightDetails> flightDetails){
        List<FlightDetails> flight =  flightDetailsRepository.saveAll(flightDetails);
        return "ok";
    }

}
