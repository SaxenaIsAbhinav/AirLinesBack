package com.flightbookingapp.service;

import com.flightbookingapp.dto.FlightResponseDTO;

public interface FlightSearchService {
    FlightResponseDTO searchFlights(String fromSkyId, String fromEntityId, String toSkyId, String toEntityId,
                                    String departureDate, String returnDate, int adults, int children, int infants,
                                    String tripType);
}