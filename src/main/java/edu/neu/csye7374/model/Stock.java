package edu.neu.csye7374.model;

import java.util.List;
import java.util.Stack;

public class Stock implements Tradable {
    private String name;
    private double price;
    private List<Double> previousPrices = new Stack<>();
    private String description;

    public List<Double> getPreviousPrices() {
        return previousPrices;
    }

    public void setPreviousPrices(List<Double> previousPrices) {
        this.previousPrices = previousPrices;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.previousPrices.add(price);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuffer stock = new StringBuffer();
        stock.append("Name: ").append(getName()).append("\t");
        stock.append("Description: ").append(getDescription()).append("\t");
        stock.append("Current Price: ").append(getPrice()).append("\t");
        stock.append("Previous Price: ").append(getPreviousPrices().get(getPreviousPrices().size() - 1));
        stock.append("\n");
        return stock.toString();
    }

    @Override
    public void setBid(String bid) {
        try {
            double bidValue = Double.parseDouble(bid);
            previousPrices.add(bidValue);
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format: " + bid);
        }
    }

    @Override
    public String getMetric() {
        int performance = 0;
        double previousPrice = 0;
        for (double price : getPreviousPrices().subList(getPreviousPrices().size() - 6, getPreviousPrices().size())) {
            if (price > previousPrice) {
                performance++;
            } else {
                performance--;
            }
            previousPrice = price;
        }
        return String.valueOf(performance);
    }
}
