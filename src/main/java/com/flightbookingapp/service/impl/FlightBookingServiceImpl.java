package com.flightbookingapp.service.impl;

import com.flightbookingapp.entity.PassengerDetails;
import com.flightbookingapp.entity.Payment;
import com.flightbookingapp.repository.PassengerDetailRepository;
import com.flightbookingapp.repository.PaymentRepository;
import com.flightbookingapp.service.FlightBookingService;

import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.flightbookingapp.mapper.RequestMapper.buildPassengerDetails;
import static com.flightbookingapp.mapper.RequestMapper.buildTicketDetails;

@Service
public class FlightBookingServiceImpl implements FlightBookingService {

    private final PassengerDetailRepository passengerDetailRepository;
    private final PaymentRepository paymentRepository;

    public FlightBookingServiceImpl(PassengerDetailRepository passengerDetailRepository, PaymentRepository paymentRepository) {
        this.passengerDetailRepository = passengerDetailRepository;
        this.paymentRepository = paymentRepository;
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


    public Optional<Payment> getTicketDetailsById(Integer pnr){
        Optional<Payment> ticketDetails = paymentRepository.findById(pnr);
        return ticketDetails;
    }

    //------------------------------Save Ticket Details______________________________
    public String postTicketDetails(Payment ticketDetails){
        Payment ticket =  paymentRepository.save(buildTicketDetails(ticketDetails));
        return "ok";
    }


}
