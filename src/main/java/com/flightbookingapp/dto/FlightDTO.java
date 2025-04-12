package com.flightbookingapp.dto;

import com.flightbookingapp.entity.Flight;

import java.util.List;

public class FlightDTO {

    private String airline;
    private String airlineLogo;
    private int totalDuration;
    private String departureTime;
    private int stops;
    private String price;
    private List<Flight.Leg> legs;

    // Constructor to initialize the FlightDTO with the values
    public FlightDTO(String airline, String airlineLogo, int totalDuration, String departureTime, int stops, String price, List<Flight.Leg> legs) {
        this.airline = airline;
        this.airlineLogo = airlineLogo;
        this.totalDuration = totalDuration;
        this.departureTime = departureTime;
        this.stops = stops;
        this.price = price;
        this.legs = legs;
    }

    // Getters and Setters for all fields
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirlineLogo() {
        return airlineLogo;
    }

    public void setAirlineLogo(String airlineLogo) {
        this.airlineLogo = airlineLogo;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Flight.Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Flight.Leg> legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "FlightDTO{" +
                "airline='" + airline + '\'' +
                ", airlineLogo='" + airlineLogo + '\'' +
                ", totalDuration=" + totalDuration +
                ", departureTime='" + departureTime + '\'' +
                ", stops=" + stops +
                ", price='" + price + '\'' +
                ", legs=" + legs +
                '}';
    }
}
