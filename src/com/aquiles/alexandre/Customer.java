package com.aquiles.alexandre;

import java.util.ArrayList;
import java.util.Collection;

public class Customer {

    private String name;
    private Collection<Rental> rentals;

    public Customer(String name) {
        super();
        rentals = new ArrayList<Rental>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            //add frequent renter points
            frequentRenterPoints++;

            //add bonus for a two day new release rental
            if (rental.getMovie().getPriceCode() == Movie.PriceCode.NEW_RELEASE && rental.getDaysRented() > 1)
                frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }

}
