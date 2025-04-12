package com.flightbookingapp.dto;

public class StopPriceFilterDTO {
    private StopPriceDTO direct;
    private StopPriceDTO one;
    private StopPriceDTO twoOrMore;

    // Getters and Setters
    public StopPriceDTO getDirect() {
        return direct;
    }

    public void setDirect(StopPriceDTO direct) {
        this.direct = direct;
    }

    public StopPriceDTO getOne() {
        return one;
    }

    public void setOne(StopPriceDTO one) {
        this.one = one;
    }

    public StopPriceDTO getTwoOrMore() {
        return twoOrMore;
    }

    public void setTwoOrMore(StopPriceDTO twoOrMore) {
        this.twoOrMore = twoOrMore;
    }
}

