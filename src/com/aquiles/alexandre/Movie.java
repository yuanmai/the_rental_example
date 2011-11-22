package com.aquiles.alexandre;

public class Movie {

    public enum PriceCode implements Price {
        REGULAR {
            public int getFrequentRenterPoints(Integer daysRented) {
                return 1;
            }
        }, NEW_RELEASE {
            public int getFrequentRenterPoints(Integer daysRented) {
                return daysRented > 1 ? 2 : 1;
            }
        }, CHILDRENS {
            public int getFrequentRenterPoints(Integer daysRented) {
                return 1;
            }
        }
    }

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
        switch (getPriceCode()) {
            case REGULAR:
            {
                double result = 0;
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                return result;
            }
            case NEW_RELEASE:
            {
                double result = 0;
                result += daysRented * 3;
                return result;
            }
            case CHILDRENS:
            {
                double result = 0;
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                return result;
            }
        }
        return 0;
    }
}
