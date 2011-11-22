package com.aquiles.alexandre;

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
            return daysRented * 3;
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
