package com.flightbookingapp.controller;

import com.flightbookingapp.entity.Payment;
import com.flightbookingapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }
    @CrossOrigin
    @GetMapping("/{pnr}")
    public Payment getPaymentByPnr(@PathVariable Integer pnr) {
        return paymentService.getPaymentByPnr(pnr);
    }
    @CrossOrigin
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
    @CrossOrigin
    @GetMapping("/passenger/{name}")
    public List<Payment> getPaymentsByPassenger(@PathVariable String name) {
        return paymentService.getPaymentsByPassengerName(name);
    }

    @CrossOrigin
    @PutMapping("/{pnr}")
    public Payment updatePayment(@PathVariable Integer pnr, @RequestBody Payment payment) {
        return paymentService.updatePayment(pnr, payment);
    }

    @CrossOrigin
    @DeleteMapping("/{pnr}")
    public void deletePayment(@PathVariable Integer pnr) {
        paymentService.deletePayment(pnr);
    }
}
