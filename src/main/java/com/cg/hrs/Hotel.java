package com.cg.hrs;

public class Hotel {
	private String name;
	private int regularCustomerRate;

	public Hotel(String name, int regularCustomerRate) {
		this.name = name;
		this.regularCustomerRate = regularCustomerRate;
	}
	
	@Override
	public String toString() {
		return "Hotel: "+name+" \tRegular Customer Rates: "+regularCustomerRate;
	}

}
