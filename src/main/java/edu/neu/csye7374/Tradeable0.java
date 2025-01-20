package edu.neu.csye7374;

public abstract class Tradeable0 implements Tradable{
    protected double price;

    public Tradeable0(double initialPrice) {
        this.price = initialPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public void setBid(String bid) {
        try {
            double bidAmount = Double.parseDouble(bid);
            setPrice(getPrice() + bidAmount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format: " + bid);
        }
    }

    @Override
    public String getMetric() {
        double benchmark = 200;
        double metric = ((price - benchmark) / benchmark) * 100; // Result is a percentage
        return String.format("%.2f", metric);
    }
}
