package com.flightbookingapp.mapper;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalTime;

import com.flightbookingapp.entity.PassengerDetails;
import com.flightbookingapp.entity.TicketDetails;

public class RequestMapper {
    public static PassengerDetails buildPassengerDetails(PassengerDetails passengerDetails) {
        PassengerDetails passenger = new PassengerDetails();
        passenger.setFullName(passengerDetails.getFullName());
        passenger.setAge(passengerDetails.getAge());
        passenger.setEmailId(passengerDetails.getEmailId());
        passenger.setMobileNumber(passengerDetails.getMobileNumber());
        passenger.setPassword(passengerDetails.getPassword());


    return passenger;

    }

    public static TicketDetails buildTicketDetails(TicketDetails ticketDetails) {
        TicketDetails ticket = new TicketDetails();
        ticket.setPnr(ticketDetails.getPnr());
        ticket.setPassenger_Name(ticketDetails.getPassenger_Name());
        ticket.setFlight_Number(ticketDetails.getFlight_Number());
        ticket.setSeat_Number(ticketDetails.getSeat_Number());
        ticket.setBoarding(ticketDetails.getBoarding());
        ticket.setDestination(ticketDetails.getDestination());
        ticket.setDeparture_Date(ticketDetails.getDeparture_Date());
        ticket.setDeparture_Time(ticketDetails.getDeparture_Time());
        ticket.setFair(ticketDetails.getFair());
        ticket.setAirline(ticketDetails.getAirline());

        return ticket;

    }

}

