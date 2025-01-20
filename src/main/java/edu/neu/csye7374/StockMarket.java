package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private List<Stock> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }


    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public void tradeStock(String name, String bid) {
        for (Stock stock : stocks) {
            if (stock.name.equals(name)) {
                stock.setBid(bid);
                System.out.println(stock);
            }
        }
    }

    public void displayStocks() {
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }
}
