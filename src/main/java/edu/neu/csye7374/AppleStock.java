package edu.neu.csye7374;

public class AppleStock extends Stock{

    public AppleStock() {
        super("Apple Inc.", 150.00, "Apple Common Stock");
    }
    @Override
    public void setBid(String bid) {
        double bidAmount = Double.parseDouble(bid);
        setPrice(getPrice() + bidAmount);
    }

    @Override
    public String getMetric() {
        return "Apple Metric: " + Math.log(getPrice());
    }
}
