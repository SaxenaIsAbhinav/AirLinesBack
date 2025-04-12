package com.flightbookingapp.extra;

public class FlightSearchDTO {
    private String tripType;
    private String fromSkyId;
    private String fromEntityId;
    private String fromTitle;
    private String fromSubtitle;
    private String toSkyId;
    private String toEntityId;
    private String toTitle;
    private String toSubtitle;
    private String departureDate;
    private String returnDate;
    private int adults;
    private int children;
    private int infants;
    private String cabinClass;

    // Default constructor
    public FlightSearchDTO() {
    }

    // Getters and setters
    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getFromSkyId() {
        return fromSkyId;
    }

    public void setFromSkyId(String fromSkyId) {
        this.fromSkyId = fromSkyId;
    }

    public String getFromEntityId() {
        return fromEntityId;
    }

    public void setFromEntityId(String fromEntityId) {
        this.fromEntityId = fromEntityId;
    }

    public String getFromTitle() {
        return fromTitle;
    }

    public void setFromTitle(String fromTitle) {
        this.fromTitle = fromTitle;
    }

    public String getFromSubtitle() {
        return fromSubtitle;
    }

    public void setFromSubtitle(String fromSubtitle) {
        this.fromSubtitle = fromSubtitle;
    }

    public String getToSkyId() {
        return toSkyId;
    }

    public void setToSkyId(String toSkyId) {
        this.toSkyId = toSkyId;
    }

    public String getToEntityId() {
        return toEntityId;
    }

    public void setToEntityId(String toEntityId) {
        this.toEntityId = toEntityId;
    }

    public String getToTitle() {
        return toTitle;
    }

    public void setToTitle(String toTitle) {
        this.toTitle = toTitle;
    }

    public String getToSubtitle() {
        return toSubtitle;
    }

    public void setToSubtitle(String toSubtitle) {
        this.toSubtitle = toSubtitle;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getInfants() {
        return infants;
    }

    public void setInfants(int infants) {
        this.infants = infants;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }
}
