package com.flightbookingapp.controller;

import com.flightbookingapp.entity.Payment;
import com.flightbookingapp.exception.PaymentNotFoundException;
import com.flightbookingapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create multiple payments (saving tickets for all passengers)
    @PostMapping
    public ResponseEntity<List<Payment>> createPayments(@RequestBody List<Payment> payments) {
        List<Payment> savedPayments = paymentService.createPayments(payments);
        return new ResponseEntity<>(savedPayments, HttpStatus.CREATED);
    }

    // Get payment by PNR
    @GetMapping("/{pnr}")
    public ResponseEntity<Payment> getPaymentByPnr(@PathVariable Integer pnr) {
        Payment payment = paymentService.getPaymentByPnr(pnr);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    // Get all payments
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    // Get payments by passenger name
    @GetMapping("/passenger/{name}")
    public ResponseEntity<List<Payment>> getPaymentsByPassengerName(@PathVariable String name) {
        List<Payment> payments = paymentService.getPaymentsByPassengerName(name);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    // Update payment by PNR
    @PutMapping("/{pnr}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Integer pnr, @RequestBody Payment paymentDetails) {
        Payment updatedPayment = paymentService.updatePayment(pnr, paymentDetails);
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    // Delete payment by PNR
    @DeleteMapping("/{pnr}")
    public ResponseEntity<Void> deletePayment(@PathVariable Integer pnr) {
        paymentService.deletePayment(pnr);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
