package com.flightbookingapp.entity;

import java.util.List;

public class Flight {
    private List<Leg> legs;
    private double price;

    public Flight() {}

    public Flight(List<Leg> legs, double price) {
        this.legs = legs;
        this.price = price;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static class Leg {
        private String origin;
        private String destination;
        private String departure;
        private String arrival;
        private int durationInMinutes;
        private int stopCount;

        public Leg() {}

        public Leg(String origin, String destination, String departure, String arrival, int durationInMinutes, int stopCount) {
            this.origin = origin;
            this.destination = destination;
            this.departure = departure;
            this.arrival = arrival;
            this.durationInMinutes = durationInMinutes;
            this.stopCount = stopCount;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getDeparture() {
            return departure;
        }

        public void setDeparture(String departure) {
            this.departure = departure;
        }

        public String getArrival() {
            return arrival;
        }

        public void setArrival(String arrival) {
            this.arrival = arrival;
        }

        public int getDurationInMinutes() {
            return durationInMinutes;
        }

        public void setDurationInMinutes(int durationInMinutes) {
            this.durationInMinutes = durationInMinutes;
        }

        public int getStopCount() {
            return stopCount;
        }

        public void setStopCount(int stopCount) {
            this.stopCount = stopCount;
        }
    }
}

