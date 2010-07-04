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
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental record for " + getName() + "\n";
		for(Rental rental : rentals) {
			frequentRenterPoints += rental.getFrequentRenterPoints(frequentRenterPoints);
			
			//show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
			totalAmount += rental.getCharge();
		}
		
		//add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	private double getTotalCharge() {
		double totalAmount = 0;
		for(Rental rental : rentals) {
			totalAmount += rental.getCharge();
		}
		return totalAmount;
	}

}

	
	