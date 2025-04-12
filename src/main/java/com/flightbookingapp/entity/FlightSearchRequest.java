package com.flightbookingapp.entity;

public class FlightSearchRequest {
    public String tripType;
    public String fromSkyId;
    public String fromEntityId;
    public String fromTitle;
    public String fromSubtitle;
    public String toSkyId;
    public String toEntityId;
    public String toTitle;
    public String toSubtitle;
    public String departureDate;
    public String returnDate;
    public String adults;
    public String children;
    public String infants;
    public String cabinClass;

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

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getInfants() {
        return infants;
    }

    public void setInfants(String infants) {
        this.infants = infants;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }
}
