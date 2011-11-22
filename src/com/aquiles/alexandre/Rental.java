package com.aquiles.alexandre;

public class Rental {

    private Movie movie;
    private Integer daysRented;

    public Rental(Movie movie, Integer daysRented) {
        super();
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getCharge() {
        return getMovie().getCharge(daysRented);
    }

    int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(daysRented);
    }

}
