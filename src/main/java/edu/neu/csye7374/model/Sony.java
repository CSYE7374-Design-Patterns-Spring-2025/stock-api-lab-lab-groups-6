package edu.neu.csye7374.model;

import edu.neu.csye7374.model.Stock;

import java.util.List;

public class Sony extends Stock {

    public Sony(String name, double price, String description, List<Double> previousPrices) {
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
                performance += 2;
            } else {
                performance -= 2;
            }
            previousPrice = price;
        }
        return String.valueOf(performance);
    }
}
