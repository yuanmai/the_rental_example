package com.aquiles.alexandre;

public class Movie {

    private final String title;
    private final PriceCode priceCode;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    int getFrequentRenterPoints(Integer daysRented) {
        return getPriceCode().getFrequentRenterPoints(daysRented);
    }

    double getCharge(Integer daysRented) {
        return getPriceCode().getCharge(daysRented);
    }
}
