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


//package com.airlineticketbooking.model;
//
//import java.util.List;
//
//public class Flight {
//    private String flightId;
//    private double price;
//    private String currency;
//    private int availableSeats;
//    private List<Leg> legs;
//
//    // Constructor
//    public Flight(String flightId, double price, String currency, int availableSeats, List<Leg> legs) {
//        this.flightId = flightId;
//        this.price = price;
//        this.currency = currency;
//        this.availableSeats = availableSeats;
//        this.legs = legs;
//    }
//
//    // Getters and Setters
//    public String getFlightId() {
//        return flightId;
//    }
//
//    public void setFlightId(String flightId) {
//        this.flightId = flightId;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    public int getAvailableSeats() {
//        return availableSeats;
//    }
//
//    public void setAvailableSeats(int availableSeats) {
//        this.availableSeats = availableSeats;
//    }
//
//    public List<Leg> getLegs() {
//        return legs;
//    }
//
//    public void setLegs(List<Leg> legs) {
//        this.legs = legs;
//    }
//
//    public static class Leg {
//        private String origin;
//        private String destination;
//        private String departureTime;
//        private String arrivalTime;
//        private int durationInMinutes;
//        private int stopCount;
//
//        // Constructor
//        public Leg(String origin, String destination, String departureTime, String arrivalTime, int durationInMinutes, int stopCount) {
//            this.origin = origin;
//            this.destination = destination;
//            this.departureTime = departureTime;
//            this.arrivalTime = arrivalTime;
//            this.durationInMinutes = durationInMinutes;
//            this.stopCount = stopCount;
//        }
//
//        // Getters and Setters
//        public String getOrigin() {
//            return origin;
//        }
//
//        public void setOrigin(String origin) {
//            this.origin = origin;
//        }
//
//        public String getDestination() {
//            return destination;
//        }
//
//        public void setDestination(String destination) {
//            this.destination = destination;
//        }
//
//        public String getDepartureTime() {
//            return departureTime;
//        }
//
//        public void setDepartureTime(String departureTime) {
//            this.departureTime = departureTime;
//        }
//
//        public String getArrivalTime() {
//            return arrivalTime;
//        }
//
//        public void setArrivalTime(String arrivalTime) {
//            this.arrivalTime = arrivalTime;
//        }
//
//        public int getDurationInMinutes() {
//            return durationInMinutes;
//        }
//
//        public void setDurationInMinutes(int durationInMinutes) {
//            this.durationInMinutes = durationInMinutes;
//        }
//
//        public int getStopCount() {
//            return stopCount;
//        }
//
//        public void setStopCount(int stopCount) {
//            this.stopCount = stopCount;
//        }
//    }
//}
