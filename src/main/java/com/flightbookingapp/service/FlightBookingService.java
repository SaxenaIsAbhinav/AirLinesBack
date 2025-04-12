package com.flightbookingapp.service;

import org.springframework.stereotype.Service;

import com.flightbookingapp.entity.PassengerDetails;
import com.flightbookingapp.entity.TicketDetails;

import java.util.Optional;

@Service
public interface FlightBookingService {


  PassengerDetails getPassengerDetailsByEmailId(String emailId);
  TicketDetails getTicketDetailsById(int pnr);

  String postPassengerDetails(PassengerDetails passengerDetails);

  String updatePassengerDetails(PassengerDetails passengerDetails);

  String postTicketDetails(TicketDetails ticketDetails);

  void deletePassengerDetailsByEmailId(String emailId);

}
