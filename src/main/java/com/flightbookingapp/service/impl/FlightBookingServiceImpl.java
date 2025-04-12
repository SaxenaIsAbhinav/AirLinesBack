package com.flightbookingapp.service.impl;

import com.flightbookingapp.entity.PassengerDetails;
import com.flightbookingapp.entity.TicketDetails;
import com.flightbookingapp.repository.PassengerDetailRepository;
import com.flightbookingapp.repository.TicketDetailRepository;
import com.flightbookingapp.service.FlightBookingService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.flightbookingapp.mapper.RequestMapper.buildPassengerDetails;
import static com.flightbookingapp.mapper.RequestMapper.buildTicketDetails;

@Service
public class FlightBookingServiceImpl implements FlightBookingService {

    private final PassengerDetailRepository passengerDetailRepository;
    private final TicketDetailRepository ticketDetailRepository;

    public FlightBookingServiceImpl(PassengerDetailRepository passengerDetailRepository, TicketDetailRepository ticketDetailRepository) {
        this.passengerDetailRepository = passengerDetailRepository;
        this.ticketDetailRepository = ticketDetailRepository;
    }

 //   _____________________________Fetching Profile Details___________________________________________________
    public PassengerDetails getPassengerDetailsByEmailId(String emailId){
        PassengerDetails passengerDetails =  passengerDetailRepository.findByEmailId(emailId);
        return passengerDetails;
    }


    //   _________________________Save Profile Details_______________________________________________________
    public String postPassengerDetails(PassengerDetails passengerDetails){
        PassengerDetails passenger =  passengerDetailRepository.save(buildPassengerDetails(passengerDetails));
        return "ok";
    }
    //   _________________________Update Profile Details__________________________________________

    public String updatePassengerDetails(PassengerDetails passengerDetails) {
        passengerDetailRepository.updatePassengerDetailsById(passengerDetails.getFullName(),
                passengerDetails.getEmailId(), passengerDetails.getMobileNumber(), passengerDetails.getPassword(), passengerDetails.getAge() );
        return "updated";
    }

   // _____________________________Deleting Profile Details___________________________________________________

    public void deletePassengerDetailsByEmailId(String emailId){
        passengerDetailRepository.deleteByEmailId(emailId);

    }

    //   _____________________________Fetching Ticket Details___________________________________________________


    public TicketDetails getTicketDetailsById(int pnr){
        TicketDetails ticketDetails = ticketDetailRepository.findById(pnr);
        return ticketDetails;
    }

    //------------------------------Save Ticket Details______________________________
    public String postTicketDetails(TicketDetails ticketDetails){
        TicketDetails ticket =  ticketDetailRepository.save(buildTicketDetails(ticketDetails));
        return "ok";
    }

}
