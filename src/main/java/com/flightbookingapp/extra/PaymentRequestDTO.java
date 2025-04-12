package com.flightbookingapp.extra;

public class PaymentRequestDTO {
    private String successUrl;
    private String cancelUrl;
    private Double amount; // Amount in the smallest unit
    private String currency;
    private String userId; // Provided by the frontend (optional)
    private String flightId;

    // Default constructor, getters, and setters
    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency != null ? currency : "inr"; // Default to INR if not provided
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFlightId() {
        return flightId != null ? flightId : "1234def"; // Default flight ID
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    // Add method to get amount in decimal
    public Double getAmountInDecimal() {
        return amount != null ? amount : 0;
    }

    // Validation logic for missing or invalid values
    public void validateAndSetDefaults(String backendUserId) {
        if (userId == null || userId.isEmpty()) {
            userId = backendUserId; // Override with backend-provided user ID
        }
        if (amount == null || amount <= 0) {
            amount = 1000.0; // Default amount (smallest unit)
        }
        if (currency == null || currency.isEmpty()) {
            currency = "inr"; // Default currency
        }
        if (flightId == null || flightId.isEmpty()) {
            flightId = "DEFAULT_FLIGHT_ID"; // Default flight ID
        }
    }
}
