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

        return getCharge(daysRented1, movie1);
    }

    private double getCharge(Integer daysRented, Movie movie) {
        double result = 0;
        switch (movie.getPriceCode()) {
            case REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += daysRented * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
        }
        return result;
    }

    int getFrequentRenterPoints() {
        Integer daysRented1 = getDaysRented();
        Movie movie1 = getMovie();

        return getFrequentRenterPoints(daysRented1, movie1);
    }

    private int getFrequentRenterPoints(Integer daysRented, Movie movie1) {
        return movie1.getPriceCode() == Movie.PriceCode.NEW_RELEASE
                && daysRented > 1 ? 2 : 1;
    }
}
