package com.aquiles.alexandre;

public class Movie {

    public enum PriceCode {REGULAR, NEW_RELEASE, CHILDRENS}

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
        return getPriceCode() == PriceCode.NEW_RELEASE
                && daysRented > 1 ? 2 : 1;
    }

    double getCharge(Integer daysRented) {
        double result = 0;
        switch (getPriceCode()) {
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
}
