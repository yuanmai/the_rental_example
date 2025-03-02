package com.aquiles.alexandre;

import org.junit.Assert;
import org.junit.Test;

import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class RentalTest {

    @Test
    public void shortRegularRental() {
        Customer customer = createCustomer();
        addRental(customer, "Groundhog Day", Movie.PriceCode.REGULAR, 2);

        String expected =
                new StatementConfig()
                        .addPartialAmount("Groundhog Day", 2.0)
                        .addTotalAmount(2.0)
                        .addFrequentRenterPoints(1)
                        .expectedStatement();

        Assert.assertEquals(expected, customer.statement());
    }

    @Test
    public void longRegularRental() {
        Customer customer = createCustomer();
        addRental(customer, "Groundhog Day", Movie.PriceCode.REGULAR, 3);

        String expected =
                new StatementConfig()
                        .addPartialAmount("Groundhog Day", 3.5)
                        .addTotalAmount(3.5)
                        .addFrequentRenterPoints(1)
                        .expectedStatement();

        Assert.assertEquals(expected, customer.statement());
    }

    @Test
    public void shortNewReleaseRental() {
        Customer customer = createCustomer();
        addRental(customer, "X-Men X", Movie.PriceCode.NEW_RELEASE, 1);

        String expected =
                new StatementConfig()
                        .addPartialAmount("X-Men X", 3.0)
                        .addTotalAmount(3.0)
                        .addFrequentRenterPoints(1)
                        .expectedStatement();

        Assert.assertEquals(expected, customer.statement());
    }

    @Test
    public void longNewReleaseRental() {
        Customer customer = createCustomer();
        addRental(customer, "X-Men X", Movie.PriceCode.NEW_RELEASE, 2);

        String expected =
                new StatementConfig()
                        .addPartialAmount("X-Men X", 6.0)
                        .addTotalAmount(6.0)
                        .addFrequentRenterPoints(2)
                        .expectedStatement();

        Assert.assertEquals(expected, customer.statement());
    }

    @Test
    public void shortChildrensRental() {
        Customer customer = createCustomer();
        addRental(customer, "Toy Story", Movie.PriceCode.CHILDRENS, 3);

        String expected =
                new StatementConfig()
                        .addPartialAmount("Toy Story", 1.5)
                        .addTotalAmount(1.5)
                        .addFrequentRenterPoints(1)
                        .expectedStatement();

        Assert.assertEquals(expected, customer.statement());
    }

    @Test
    public void longChildrensRental() {
        Customer customer = createCustomer();
        addRental(customer, "Toy Story", Movie.PriceCode.CHILDRENS, 4);

        String expected =
                new StatementConfig()
                        .addPartialAmount("Toy Story", 3.0)
                        .addTotalAmount(3.0)
                        .addFrequentRenterPoints(1)
                        .expectedStatement();

        Assert.assertEquals(expected, customer.statement());
    }

    @Test
    public void variousRentals() {
        Customer customer = createCustomer();
        addRental(customer, "Groundhog Day", Movie.PriceCode.REGULAR, 3);
        addRental(customer, "X-Men X", Movie.PriceCode.NEW_RELEASE, 2);
        addRental(customer, "Toy Story", Movie.PriceCode.CHILDRENS, 4);

        String expected =
                new StatementConfig()
                        .addPartialAmount("Groundhog Day", 3.5)
                        .addPartialAmount("X-Men X", 6.0)
                        .addPartialAmount("Toy Story", 3.0)
                        .addTotalAmount(12.5)
                        .addFrequentRenterPoints(4)
                        .expectedStatement();

        Assert.assertEquals(expected, customer.statement());
    }

    @Test
    public void expectedStatementTest() {
        String result = new StatementConfig().addPartialAmount("Groundhog Day", 3.0).addTotalAmount(3.0).addFrequentRenterPoints(1).expectedStatement();
        String expected = "Rental record for Luke\n";
        expected += "\tGroundhog Day\t3.0\n";
        expected += "Amount owed is 3.0\n";
        expected += "You earned 1 frequent renter points";
        Assert.assertEquals(expected, result);
    }

    private Customer createCustomer() {
        return new Customer("Luke");
    }

    private void addRental(Customer customer, String movieName, Movie.PriceCode priceCode, Integer daysRented) {
        Movie movie = new Movie(movieName, priceCode);
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);
    }

}

class StatementConfig {
    private Map<String, Double> partialAmountsByMovieName;
    private Double totalAmount;
    private Integer frequentRenterPoints;

    public StatementConfig() {
        this.partialAmountsByMovieName = new LinkedHashMap<String, Double>();
    }

    public StatementConfig addPartialAmount(String movieName, Double partialAmount) {
        partialAmountsByMovieName.put(movieName, partialAmount);
        return this;
    }

    public StatementConfig addTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public StatementConfig addFrequentRenterPoints(Integer frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
        return this;
    }

    public String expectedStatement() {
        String format = "Rental record for Luke\n";
        for (int i = 0; i < partialAmountsByMovieName.size(); i++) {
            format += "\t%s\t%.1f\n";
        }
        format += "Amount owed is %.1f\n";
        format += "You earned %d frequent renter points";

        Formatter formatter = new Formatter();
        formatter.format(Locale.US, format, getParameters());

        return formatter.toString();
    }

    private Object[] getParameters() {
        Object[] parameters = new Object[2 * partialAmountsByMovieName.size() + 2];
        int i = -1;
        for (String movieName : partialAmountsByMovieName.keySet()) {
            parameters[++i] = movieName;
            parameters[++i] = partialAmountsByMovieName.get(movieName);
        }
        parameters[++i] = totalAmount;
        parameters[++i] = frequentRenterPoints;
        return parameters;
    }

}
