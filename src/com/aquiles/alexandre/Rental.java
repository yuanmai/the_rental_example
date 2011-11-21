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

    public Integer getDaysRented() {
        return daysRented;
    }

    double getCharge() {
        Integer daysRented1 = getDaysRented();
        Movie movie1 = getMovie();

        return movie1.getCharge(daysRented1);
    }

    int getFrequentRenterPoints() {
        Integer daysRented1 = getDaysRented();
        Movie movie1 = getMovie();

        return movie1.getFrequentRenterPoints(daysRented1);
    }

}
