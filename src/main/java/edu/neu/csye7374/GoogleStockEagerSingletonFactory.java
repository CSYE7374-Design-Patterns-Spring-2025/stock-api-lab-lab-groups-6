package edu.neu.csye7374;

public class GoogleStockEagerSingletonFactory implements StockFactory {
    private static final GoogleStockEagerSingletonFactory instance = new GoogleStockEagerSingletonFactory();

    private GoogleStockEagerSingletonFactory() {}

    public static GoogleStockEagerSingletonFactory getInstance() {
        return instance;
    }

    @Override
    public Stock createStock() {
        return new GoogleStock();
    }
}

