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
        double result = 0;
        switch (getMovie().getPriceCode()) {
            case REGULAR:
                result += 2;
                if (getDaysRented() > 2)
                    result += (getDaysRented() - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (getDaysRented() > 3)
                    result += (getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }

    int getFrequentRenterPoints() {
        return getMovie().getPriceCode() == Movie.PriceCode.NEW_RELEASE
                && getDaysRented() > 1 ? 2 : 1;
    }
}
