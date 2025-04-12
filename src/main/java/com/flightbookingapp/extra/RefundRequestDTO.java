package com.flightbookingapp.extra;

public class RefundRequestDTO {
    private String paymentIntentId; // Stripe's Payment Intent ID
    private String transactionId;  // Transaction ID in your system

    // Getters and Setters
    public String getPaymentIntentId() {
        return paymentIntentId;
    }

    public void setPaymentIntentId(String paymentIntentId) {
        this.paymentIntentId = paymentIntentId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
