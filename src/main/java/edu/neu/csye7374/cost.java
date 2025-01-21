package edu.neu.csye7374;

public class COST extends Stock implements Tradable0 {

	public COST(String name, double price, String description) {
		super("COST", price, "Costco Stock");
		
	}

	@Override
	public double getMetric() {
		// TODO Auto-generated method stub
		return (getPrice() * 0.6);
	}  

}
