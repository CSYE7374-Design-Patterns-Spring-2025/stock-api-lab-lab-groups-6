package edu.neu.csye7374;

public class GoogleStock extends Stock{

    public GoogleStock() {
        super("Google Inc.", 125.00, "Google Common Stock");
    }
    @Override
    public void setBid(String bid) {
        double bidAmount = Double.parseDouble(bid);
        setPrice(getPrice() + bidAmount);
    }

    @Override
    public String getMetric() {
        return "Google Metric: " + Math.log(getPrice());
    }
}

