package com.aquiles.alexandre;

public class Movie {

    public enum PriceCode implements Price {
        REGULAR {
            public double getCharge(Integer daysRented) {
                return daysRented > 2 ? 2 + (daysRented - 2) * 1.5 : 2;
            }

            public int getFrequentRenterPoints(Integer daysRented) {
                return 1;
            }
        }, NEW_RELEASE {
            public int getFrequentRenterPoints(Integer daysRented) {
                return daysRented > 1 ? 2 : 1;
            }

            public double getCharge(Integer daysRented) {
                double result = 0;
                result += daysRented * 3;
                return result;
            }
        }, CHILDRENS {
            public int getFrequentRenterPoints(Integer daysRented) {
                return 1;
            }

            public double getCharge(Integer daysRented) {
                return daysRented > 3 ? 1.5 + (daysRented - 3) * 1.5 : 1.5;
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
        return getPriceCode().getCharge(daysRented);
    }
}
