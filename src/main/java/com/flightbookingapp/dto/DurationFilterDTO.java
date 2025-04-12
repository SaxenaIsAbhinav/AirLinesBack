package com.flightbookingapp.dto;

public class DurationFilterDTO {
    private int min;
    private int max;
    private int multiCityMin;
    private int multiCityMax;

    // Getters and Setters
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMultiCityMin() {
        return multiCityMin;
    }

    public void setMultiCityMin(int multiCityMin) {
        this.multiCityMin = multiCityMin;
    }

    public int getMultiCityMax() {
        return multiCityMax;
    }

    public void setMultiCityMax(int multiCityMax) {
        this.multiCityMax = multiCityMax;
    }
}



