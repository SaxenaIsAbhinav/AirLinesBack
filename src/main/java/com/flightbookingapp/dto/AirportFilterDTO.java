package com.flightbookingapp.dto;

import java.util.List;

public class AirportFilterDTO {
    private String city;
    private List<AirportDetailFilterDTO> airports;

    // Getters and Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<AirportDetailFilterDTO> getAirports() {
        return airports;
    }

    public void setAirports(List<AirportDetailFilterDTO> airports) {
        this.airports = airports;
    }
}

