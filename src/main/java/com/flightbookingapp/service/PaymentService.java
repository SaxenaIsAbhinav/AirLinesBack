//PaymentService.java--interface

package com.flightbookingapp.service;

import com.flightbookingapp.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);
    List<Payment> createPayments(List<Payment> payments);
    Payment getPaymentByPnr(Integer pnr);
    List<Payment> getAllPayments();
    List<Payment> getPaymentsByPassengerName(String passenger_Name);
    Payment updatePayment(Integer pnr, Payment payment);
    void deletePayment(Integer pnr);
}









//package com.flightbookingapp.service;
//
//import com.flightbookingapp.entity.Payment;
//
//import java.util.List;
//
//public interface PaymentService {
//    Payment createPayment(Payment payment);
//    Payment getPaymentByPnr(Integer pnr);
//    List<Payment> getAllPayments();
//    List<Payment> getPaymentsByPassengerName(String passenger_Name);
//    Payment updatePayment(Integer pnr, Payment payment);
//    void deletePayment(Integer pnr);
//}
