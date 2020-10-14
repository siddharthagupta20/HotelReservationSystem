package com.cg.hrs;

public class Hotel {
	private String name;
	private int regCustomerWeekdayRate;
	private int regCustomerWeekendRate;

	public Hotel(String name, int regCustomerWeekdayRate, int regCustomerWeekendRate) {
		this.name = name;
		this.regCustomerWeekdayRate = regCustomerWeekdayRate;
		this.regCustomerWeekendRate = regCustomerWeekendRate;
	}

	public String getName() {
		return name;
	}

	public int getRegCustomerWeekdayRate() {
		return regCustomerWeekdayRate;
	}

	public int getRegCustomerWeekendRate() {
		return regCustomerWeekendRate;
	}

	@Override
	public String toString() {
		return "Hotel: " + name + ",\tRegular Customer Weekday Rates: $" + regCustomerWeekdayRate+",\tRegular Customer Weekend Rates"+regCustomerWeekendRate;
	}

}
