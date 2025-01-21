package edu.neu.csye7374;

public class IBMStock extends Stock {
    private double stabilityFactor;

    public IBMStock() {
        super("IBM Corp.", 135.00, "IBM Common Stock");
        this.stabilityFactor = 1.1; 
    }

    @Override
    public void setBid(String bid) {
        try {
            double bidAmount = Double.parseDouble(bid);
            double priceChange = bidAmount * stabilityFactor;
            setPrice(getPrice() + priceChange);
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format for IBM Stock: " + bid);
        }
    }

    @Override
    public String getMetric() {
        double metric = getPrice() / stabilityFactor;
        return String.format("IBM Metric: %.2f (Stability Factor: %.2f)", metric, stabilityFactor);
    }
}