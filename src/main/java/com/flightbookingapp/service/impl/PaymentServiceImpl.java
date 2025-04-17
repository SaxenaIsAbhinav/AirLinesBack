//PaymentServiceImpl.java--class

package com.flightbookingapp.service.impl;

import com.flightbookingapp.entity.Payment;
import com.flightbookingapp.exception.PaymentNotFoundException;
import com.flightbookingapp.repository.PaymentRepository;
import com.flightbookingapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> createPayments(List<Payment> payments) {
        return paymentRepository.saveAll(payments);
    }

    @Override
    public Payment getPaymentByPnr(Integer pnr) {
        return paymentRepository.findById(pnr)
                .orElseThrow(() -> new PaymentNotFoundException("Payment with PNR " + pnr + " not found"));
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> getPaymentsByPassengerName(String passenger_Name) {
        return paymentRepository.findByPassenger_Name(passenger_Name);
    }

    @Override
    public Payment updatePayment(Integer pnr, Payment payment) {
        Payment existingPayment = getPaymentByPnr(pnr);
        payment.setPnr(existingPayment.getPnr()); // Keep original PNR
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Integer pnr) {
        Payment payment = getPaymentByPnr(pnr);
        paymentRepository.delete(payment);
    }
}

















//package com.flightbookingapp.service.impl;
//
//import com.flightbookingapp.entity.Payment;
//import com.flightbookingapp.exception.PaymentNotFoundException;
//import com.flightbookingapp.repository.PaymentRepository;
//import com.flightbookingapp.service.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class PaymentServiceImpl implements PaymentService {
//
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    @Override
//    public Payment createPayment(Payment payment) {
//        return paymentRepository.save(payment);
//    }
//
//    @Override
//    public Payment getPaymentByPnr(Integer pnr) {
//        return paymentRepository.findById(pnr)
//                .orElseThrow(() -> new PaymentNotFoundException("Payment with PNR " + pnr + " not found"));
//    }
//
//    @Override
//    public List<Payment> getAllPayments() {
//        return paymentRepository.findAll();
//    }
//
//    @Override
//    public List<Payment> getPaymentsByPassengerName(String passenger_Name) {
//        return paymentRepository.findByPassenger_Name(passenger_Name);
//    }
//
//    @Override
//    public Payment updatePayment(Integer pnr, Payment payment) {
//        Payment existing = getPaymentByPnr(pnr);
//        payment.setPnr(existing.getPnr()); // Keep original PNR
//        return paymentRepository.save(payment);
//    }
//
//    @Override
//    public void deletePayment(Integer pnr) {
//        Payment payment = getPaymentByPnr(pnr);
//        paymentRepository.delete(payment);
//    }
//}
