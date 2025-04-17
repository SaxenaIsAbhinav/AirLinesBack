package com.flightbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.flightbookingapp.entity.FlightDetails;
import com.flightbookingapp.service.FlightDetailsService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/flights")
public class FlightDetailsController {

    @Autowired
    public FlightDetailsService flightDetailsService;


//  _______________________Fetching Flight Details______________________

    @GetMapping(value = "getFlightDetails")
    public ResponseEntity<List<FlightDetails>> getFlightDetails(@RequestParam String origin,
                                                                @RequestParam String destination){
        List<FlightDetails> flights = flightDetailsService.getFlightsByRoute(origin, destination);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

// __________________________Creating Flight Details_______________________

    @PostMapping(value = "postFlightDetails")
    public ResponseEntity<String> postFlightDetails(@RequestBody List<FlightDetails> flightDetails){

        String status = flightDetailsService.postFlightDetails(flightDetails);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

}
