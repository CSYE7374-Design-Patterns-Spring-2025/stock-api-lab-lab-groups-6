package edu.neu.csye7374.model;

import java.util.List;
import java.util.Stack;

public class Stripe extends Stock {
    private List<Double> previousPrices = new Stack<>();

    public Stripe(String name, double price, String description, List<Double> previousPrices) {
        super();
        setName(name);
        setPrice(price);
        setDescription(description);
        setPreviousPrices(previousPrices);
    }

    @Override
    public String getMetric() {
        int performance = 0;
        double previousPrice = 0;
        for (double price : getPreviousPrices().subList(getPreviousPrices().size() - 6, getPreviousPrices().size())) {
            if (price > previousPrice) {
                performance++;
                performance *= 2;
            } else {
                performance--;
                performance /= 2;
            }
            previousPrice = price;
        }
        return String.valueOf(performance);
    }
}
