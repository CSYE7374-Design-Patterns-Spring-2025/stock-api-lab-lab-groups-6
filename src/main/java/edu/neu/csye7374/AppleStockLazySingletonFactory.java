package edu.neu.csye7374;

public class AppleStockLazySingletonFactory implements StockFactory {
    private static AppleStockLazySingletonFactory instance;

    private AppleStockLazySingletonFactory() {}

    public static synchronized AppleStockLazySingletonFactory getInstance() {
        if (instance == null) {
            instance = new AppleStockLazySingletonFactory();
        }
        return instance;
    }

    @Override
    public Stock createStock() {
        return new AppleStock();
    }
}