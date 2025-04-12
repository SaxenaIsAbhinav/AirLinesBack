package com.flightbookingapp.dto;

import java.util.List;

public class FlightFilterDTO {

    private DurationFilterDTO duration;
    private List<AirportFilterDTO> airports;
    private List<CarrierFilterDTO> carriers;
    private StopPriceFilterDTO stopPrices;

    // Getters and Setters
    public DurationFilterDTO getDuration() {
        return duration;
    }

    public void setDuration(DurationFilterDTO duration) {
        this.duration = duration;
    }

    public List<AirportFilterDTO> getAirports() {
        return airports;
    }

    public void setAirports(List<AirportFilterDTO> airports) {
        this.airports = airports;
    }

    public List<CarrierFilterDTO> getCarriers() {
        return carriers;
    }

    public void setCarriers(List<CarrierFilterDTO> carriers) {
        this.carriers = carriers;
    }

    public StopPriceFilterDTO getStopPrices() {
        return stopPrices;
    }

    public void setStopPrices(StopPriceFilterDTO stopPrices) {
        this.stopPrices = stopPrices;
    }
}

 