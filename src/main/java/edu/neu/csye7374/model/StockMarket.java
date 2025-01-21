package edu.neu.csye7374.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockMarket {
    private final List<Stock> stocks = new ArrayList<>();
    private static StockMarket instance;

    private StockMarket() {
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void addStocks(ArrayList<Stock> stockList) {
        stocks.addAll(stockList);
    }

    public void deleteStock(Stock stock) {
        stocks.remove(stock);
    }

    public void deleteStocks(ArrayList<Stock> stockList) {
        stocks.removeAll(stockList);
    }

    public void tradeStock(String name, double price) {
        for (Stock stock : stocks) {
            if (stock.getName().equals(name)) {
                stock.setBid(String.valueOf(stock.getPrice()));
                stock.setPrice(price);
            }
        }
    }

    public static void demo() {
        ArrayList<Stock> stock = new ArrayList<>();

        Stock stripe1 = new Stripe("Stripe", 10.0, "Stripe Stock Description", new ArrayList<>(Arrays.asList(1.0, 2.3, 3.4, 5.5, 6.6, 7.7)));
        stripe1.setBid("8.0");
        stripe1.setBid("12.0");
        stripe1.setBid("15.0");
        stripe1.setBid("18.0");
        stock.add(stripe1);

        Stock dataBricks = new DataBricks("DataBricks", 20.0, "DataBricks Stock Description", new ArrayList<>(Arrays.asList(11.0, 9.3, 13.4, 15.5, 16.6, 10.7)));
        dataBricks.setBid("11.0");
        dataBricks.setBid("12.0");
        dataBricks.setBid("13.0");
        dataBricks.setBid("7.0");
        stock.add(dataBricks);

        StockMarket market = StockMarket.getInstance();
        market.addStocks(stock);
        System.out.println("\n\n============Initial state=======================");
        System.out.println(market);

        market.tradeStock("DataBricks", 10.0);
        market.tradeStock("Stripe", 19.0);

        System.out.println("\n\n============State after one bid===================");
        System.out.println(market);

        market.tradeStock("DataBricks", 9.0);
        market.tradeStock("Stripe", 11.0);

        System.out.println("\n\n============State after two bids===================");
        System.out.println(market);

        market.deleteStock(dataBricks);
        System.out.println("\n\n============Deleted One Stock===================");
        System.out.println(market);
    }

    @Override
    public String toString() {
        StringBuilder stocksDetail = new StringBuilder();
        for (Stock stock : stocks) {
            stocksDetail.append(stock.toString());
            stocksDetail.append("Performance: ").append(stock.getMetric()).append("\n");
        }
        return stocksDetail.toString();
    }
}
