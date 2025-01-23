package edu.neu.csye7374;

public class AppleStockFactory implements StockFactory {
    @Override
    public Stock createStock() {
        return new AppleStock();
    }
}