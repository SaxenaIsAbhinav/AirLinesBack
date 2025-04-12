package com.flightbookingapp.service;

import com.flightbookingapp.entity.Airport;
import java.util.List;

public interface AirportService {
    List<Airport> searchAirports(String query);
}
