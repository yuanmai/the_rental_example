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

        double result = 0;
        switch (movie1.getPriceCode()) {
            case REGULAR:
                result += 2;
                if (daysRented1 > 2)
                    result += (daysRented1 - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += daysRented1 * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (daysRented1 > 3)
                    result += (daysRented1 - 3) * 1.5;
                break;
        }
        return result;
    }

    int getFrequentRenterPoints() {
        Integer daysRented1 = getDaysRented();
        Movie movie1 = getMovie();

        return movie1.getPriceCode() == Movie.PriceCode.NEW_RELEASE
                && daysRented1 > 1 ? 2 : 1;
    }
}
