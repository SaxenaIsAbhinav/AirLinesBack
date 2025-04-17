package com.flightbookingapp.repository;

import com.flightbookingapp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Query("SELECT p FROM Payment p WHERE p.passenger_Name = :name")
    List<Payment> findByPassenger_Name(@Param("name") String passengerName);
}