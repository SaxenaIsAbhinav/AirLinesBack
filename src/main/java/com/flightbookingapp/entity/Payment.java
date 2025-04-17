package com.flightbookingapp.entity;

//payment.java-->entity package


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Tickets")
public class Payment {

    @Id
    @Column(name = "PNR")
    private Integer pnr;

    @Column(name = "Passenger_Name")
    private String passenger_Name;

    @Column(name = "Flight_Number")
    private String flight_Number;

    @Column(name = "Seat_Number")
    private String seat_Number;

    @Column(name = "Boarding")
    private String boarding;

    @Column(name = "Destination")
    private String destination;

    @Column(name = "Departure_Date")
    private LocalDate departure_Date;

    @Column(name = "Departure_Time")
    private LocalTime departure_Time;

    @Column(name = "fair")
    private int fair;

    @Column(name = "airline")
    private String airline;

    // Getters and Setters
    public Integer getPnr() {
        return pnr;
    }

    public void setPnr(Integer pnr) {
        this.pnr = pnr;
    }

    public String getPassenger_Name() {
        return passenger_Name;
    }

    public void setPassenger_Name(String passenger_Name) {
        this.passenger_Name = passenger_Name;
    }

    public String getFlight_Number() {
        return flight_Number;
    }

    public void setFlight_Number(String flight_Number) {
        this.flight_Number = flight_Number;
    }

    public String getSeat_Number() {
        return seat_Number;
    }

    public void setSeat_Number(String seat_Number) {
        this.seat_Number = seat_Number;
    }

    public String getBoarding() {
        return boarding;
    }

    public void setBoarding(String boarding) {
        this.boarding = boarding;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDeparture_Date() {
        return departure_Date;
    }

    public void setDeparture_Date(LocalDate departure_Date) {
        this.departure_Date = departure_Date;
    }

    public LocalTime getDeparture_Time() {
        return departure_Time;
    }

    public void setDeparture_Time(LocalTime departure_Time) {
        this.departure_Time = departure_Time;
    }

    public int getFair() {
        return fair;
    }

    public void setFair(int fair) {
        this.fair = fair;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}








