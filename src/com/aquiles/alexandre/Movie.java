package com.aquiles.alexandre;

public class Movie {

    private final String title;
    private final Price price;

    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    int getFrequentRenterPoints(Integer daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

    double getCharge(Integer daysRented) {
        return price.getCharge(daysRented);
    }
}
