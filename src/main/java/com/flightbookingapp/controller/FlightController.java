package com.flightbookingapp.controller;

import com.flightbookingapp.dto.FlightResponseDTO;
import com.flightbookingapp.entity.FlightSearchRequest;
import com.flightbookingapp.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightSearchService flightSearchService;

    @PostMapping("/search-flights")
    public ResponseEntity<FlightResponseDTO> searchFlights(@RequestBody FlightSearchRequest request) {

        FlightResponseDTO result = flightSearchService.searchFlights(
                request.fromSkyId,
                request.fromEntityId,
                request.toSkyId,
                request.toEntityId,
                request.departureDate,
                request.returnDate,
                Integer.parseInt(request.adults),
                Integer.parseInt(request.children),
                Integer.parseInt(request.infants),
                request.tripType
        );

        return ResponseEntity.ok(result);
    }
}
