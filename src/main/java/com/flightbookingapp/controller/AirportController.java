package com.flightbookingapp.controller;

import com.flightbookingapp.entity.Airport;
import com.flightbookingapp.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @CrossOrigin
    @GetMapping("/test")
    public String  test() {
        return "this is up and working ";
    }

    @CrossOrigin
    @GetMapping("/search")
    public List<Airport> searchAirports(@RequestParam String query) {
        return airportService.searchAirports(query);
    }
}
