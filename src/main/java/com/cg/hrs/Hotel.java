package com.cg.hrs;

public class Hotel {
	private String name;
	private int regularCustomerRate;

	public Hotel(String name, int regularCustomerRate) {
		this.name = name;
		this.regularCustomerRate = regularCustomerRate;
	}
	public String getName() {
		return name;
	}
	public int getRegularCustomerRate() {
		return regularCustomerRate;
	}
	
	@Override
	public String toString() {
		return "Hotel: "+name+",\tRegular Customer Rates: $"+regularCustomerRate;
	}

}
