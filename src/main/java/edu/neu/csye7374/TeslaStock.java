package edu.neu.csye7374;

public class TeslaStock extends Stock {
    private double volatilityFactor;
    private double previousPrice;

    public TeslaStock() {
        super("Tesla Inc.", 200.00, "Tesla Common Stock");
        this.volatilityFactor = 1.5;
        this.previousPrice = 200.00;
    }

    @Override
    public void setBid(String bid) {
        previousPrice = getPrice();
        double bidAmount = Double.parseDouble(bid);
        // Tesla's price is more volatile, so we add a volatility factor
        double priceChange = (bidAmount - previousPrice) * volatilityFactor;
        setPrice(previousPrice + priceChange);
    }

    @Override
    public String getMetric() {
        // Calculate a unique metric based on price momentum and volatility
        double priceChange = getPrice() - previousPrice;
        double percentageChange = (priceChange / previousPrice) * 100;
        double momentum = percentageChange * volatilityFactor;
        
        // Return a more detailed metric string
        return String.format("Tesla Metric: %.2f (Momentum: %.2f%%)", 
            momentum, percentageChange);
    }
}
