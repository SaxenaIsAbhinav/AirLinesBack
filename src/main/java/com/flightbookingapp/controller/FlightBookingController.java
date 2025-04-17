package com.flightbookingapp.controller;

import com.flightbookingapp.entity.PassengerDetails;
import com.flightbookingapp.entity.Payment;
import com.flightbookingapp.service.FlightBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user/")
public class FlightBookingController {

    private final FlightBookingService flightBookingService;

    public FlightBookingController(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    // __________________________FETCHING Passenger DETAILS THROUGH EMAIL_____________________

    @CrossOrigin
    @GetMapping(value="getPassengerDetails/{emailId}")
    public ResponseEntity<PassengerDetails> getPassengerDetail(@PathVariable String emailId){

        PassengerDetails passengerDetails = flightBookingService.getPassengerDetailsByEmailId(emailId);
        System.out.println(passengerDetails + "print");
        return new ResponseEntity<>(passengerDetails, HttpStatus.OK);
    }
    // __________________________CREATING PASSENGER DETAILS_____________________

    @CrossOrigin
    @PostMapping(value="postPassengerDetails")
    public ResponseEntity<String> postPassengerDetails(@RequestBody PassengerDetails passengerDetails){

        String status = flightBookingService.postPassengerDetails(passengerDetails);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    // __________________________UPDATING PASSENGER DETAILS_____________________
    @CrossOrigin
    @PutMapping(value ="updatePassengerDetails" )
    public  ResponseEntity<String> updatePassengerDetails(@RequestBody PassengerDetails passengerDetails){

        String status = flightBookingService.updatePassengerDetails(passengerDetails);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    //__________________________ DELETING Passenger DETAILS THROUGH EMAIL_____________________

    @CrossOrigin
    @DeleteMapping(value="deletePassengerDetails/{emailId}")
    public ResponseEntity<String > deletePassengerDetail(@PathVariable String emailId) {

        flightBookingService.deletePassengerDetailsByEmailId(emailId);
        System.out.println("Successfully Removed");
        return new ResponseEntity<>("Successfully Removed", HttpStatus.OK);
    }


    // __________________________FETCHING TICKET DETAILS THROUGH PNR_____________________
    @CrossOrigin
    @GetMapping(value="TicketDetails/{pnr}")
    public ResponseEntity<Optional<Payment>> getTicketDetail(@PathVariable Integer pnr){

        Optional<Payment> ticketDetails = flightBookingService.getTicketDetailsById(pnr);
        System.out.println(ticketDetails + "print");
        return new ResponseEntity<>(ticketDetails, HttpStatus.OK);
    }
    // __________________________CREATING TICKET DETAILS_____________________

    @CrossOrigin
    @PostMapping(value="postTicketDetails")
    public ResponseEntity<String> postTicketDetails(@RequestBody Payment ticketDetails) {

        if (ticketDetails != null) {

            String status = flightBookingService.postTicketDetails(ticketDetails);
            return new ResponseEntity<>("PNR is" + ticketDetails.getPnr().toString(), HttpStatus.CREATED);
        }

        else {
            return null;
        }
    }


}