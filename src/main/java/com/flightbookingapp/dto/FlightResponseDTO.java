package com.flightbookingapp.dto;

import java.util.List;

public class FlightResponseDTO {
    private List<FlightDTO> flights;
    private FlightFilterDTO filters;

    public FlightResponseDTO(List<FlightDTO> flights, FlightFilterDTO filters) {
        this.flights = flights;
        this.filters = filters;
    }

    // Getters and Setters
    public List<FlightDTO> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDTO> flights) {
        this.flights = flights;
    }

    public FlightFilterDTO getFilters() {
        return filters;
    }

    public void setFilters(FlightFilterDTO filters) {
        this.filters = filters;
    }
}
