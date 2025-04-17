package com.flightbookingapp.service;

import com.flightbookingapp.entity.Payment;
import org.springframework.stereotype.Service;

import com.flightbookingapp.entity.PassengerDetails;

import java.util.Optional;

@Service
public interface FlightBookingService {


  PassengerDetails getPassengerDetailsByEmailId(String emailId);

  Optional<Payment> getTicketDetailsById(Integer pnr);

  String postPassengerDetails(PassengerDetails passengerDetails);

  String updatePassengerDetails(PassengerDetails passengerDetails);

  String postTicketDetails(Payment ticketDetails);

  void deletePassengerDetailsByEmailId(String emailId);

}
