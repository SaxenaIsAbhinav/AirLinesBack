
package com.flightbookingapp.exception;

public class PaymentNotFoundException extends RuntimeException {
    private Integer pnr;

    public PaymentNotFoundException(String message) {
        super(message);
    }

    public PaymentNotFoundException(String message, Integer pnr) {
        super(message);
        this.pnr = pnr;
    }

    public Integer getPnr() {
        return pnr;
    }

    @Override
    public String toString() {
        return "PaymentNotFoundException{" +
                "message=" + getMessage() +
                ", pnr=" + pnr +
                '}';
    }
}