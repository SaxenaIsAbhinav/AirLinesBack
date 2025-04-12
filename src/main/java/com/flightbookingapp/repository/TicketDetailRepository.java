package com.flightbookingapp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightbookingapp.entity.PassengerDetails;
import com.flightbookingapp.entity.TicketDetails;


@Repository
public interface TicketDetailRepository extends CrudRepository<TicketDetails, Integer> {

       TicketDetails findById(int pnr);


}

