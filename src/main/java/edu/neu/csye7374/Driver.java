package edu.neu.csye7374;

/**
 * 
 * @author Preyash Mehta
 * 
 */

public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        //your driver code here
        demo();
        System.out.println("============Main Execution End===================");
    }

    public static void demo() {
        // Get the singleton instance of the StockMarket
        StockMarket stockMarket = StockMarket.getInstance();

        // Create instances of each stock type
        AppleStock appleStock = new AppleStock();
        GoogleStock googleStock = new GoogleStock();
        TeslaStock teslaStock = new TeslaStock();
        IBMStock ibmStock = new IBMStock(); 

        // Add stocks to the market
        stockMarket.addStock(appleStock);
        stockMarket.addStock(googleStock);
        stockMarket.addStock(teslaStock);
        stockMarket.addStock(ibmStock); 

        // Display initial stocks
        System.out.println("Initial stocks in the stock market:");
        stockMarket.displayStocks();
        System.out.println();

        // Define bids for Apple stock
        double[] appleBids = {152.0, 149.5, 153.0, 150.0, 151.2, 153.4};
        System.out.println("Starting trading for Apple Stock");
        for (double bid : appleBids) {
            System.out.println("\nPlacing bid for Apple: $" + bid);
            stockMarket.tradeStock("Apple Inc.", String.valueOf(bid));
            System.out.println("Apple Stock after bid: " + appleStock);
            System.out.println("Apple Stock metric after bid: " + appleStock.getMetric());
        }
        System.out.println();

        // Define bids for Google stock
        double[] googleBids = {125.5, 127.0, 124.0, 130.0, 131.8, 130.9};
        System.out.println("Starting trading for Google Stock");
        for (double bid : googleBids) {
            System.out.println("\nPlacing bid for Google: $" + bid);
            stockMarket.tradeStock("Google Inc.", String.valueOf(bid));
            System.out.println("Google Stock after bid: " + googleStock);
            System.out.println("Google Stock metric after bid: " + googleStock.getMetric());
        }
        System.out.println();

        // Define bids for Tesla stock
        double[] teslaBids = {205.0, 198.0, 210.0, 215.0, 208.0, 220.0};
        System.out.println("\nStarting trading for Tesla Stock");
        for (double bid : teslaBids) {
            System.out.println("\nPlacing bid for Tesla: $" + bid);
            stockMarket.tradeStock("Tesla Inc.", String.valueOf(bid));
            System.out.println("Tesla Stock after bid: " + teslaStock);
            System.out.println("Tesla Stock metric after bid: " + teslaStock.getMetric());
        }
        System.out.println();

        // Define bids for IBM stock
        double[] ibmBids = {135.5, 136.0, 134.8, 137.0, 135.2, 138.0};
        System.out.println("\nStarting trading for IBM Stock");
        for (double bid : ibmBids) {
            System.out.println("\nPlacing bid for IBM: $" + bid);
            stockMarket.tradeStock("IBM Corp.", String.valueOf(bid));
            System.out.println("IBM Stock after bid: " + ibmStock);
            System.out.println("IBM Stock metric after bid: " + ibmStock.getMetric());
        }
        System.out.println();

        // Display all stocks after trading
        System.out.println("All stocks in the market after trading:");
        stockMarket.displayStocks();

        // Removing a stock, for example, Apple
        stockMarket.removeStock(appleStock);
        System.out.println("\nStocks in the stock market after removing Apple:");
        stockMarket.displayStocks();
    }
}
