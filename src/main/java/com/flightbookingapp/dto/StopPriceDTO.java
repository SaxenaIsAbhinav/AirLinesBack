package com.flightbookingapp.dto;

public class StopPriceDTO {
    private boolean isPresent;
    private String formattedPrice;

    // Getters and Setters
    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public String getFormattedPrice() {
        return formattedPrice;
    }

    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }
}