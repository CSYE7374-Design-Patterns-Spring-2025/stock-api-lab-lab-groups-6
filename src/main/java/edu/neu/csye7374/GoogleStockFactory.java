package edu.neu.csye7374;

public class GoogleStockFactory implements StockFactory {
    @Override
    public Stock createStock() {
        return new GoogleStock();
    }
}