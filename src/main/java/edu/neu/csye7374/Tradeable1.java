package edu.neu.csye7374;

public abstract class Tradeable1 implements Tradable {
    protected double price; // Protected to allow access in subclasses

    public Tradeable1(double initialPrice) {
        this.price = initialPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method that subclasses must implement
    @Override
    public abstract void setBid(String bid);

    // Provides a default implementation for getMetric
    @Override
    public String getMetric() {
        double highBenchmark = 2500; // A higher threshold for performance measurement
        double metric = ((price - highBenchmark) / highBenchmark) * 100; // Result is a percentage
        return String.format("%.2f", metric);
    }
}

