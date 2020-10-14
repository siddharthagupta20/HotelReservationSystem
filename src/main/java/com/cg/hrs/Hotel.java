package com.cg.hrs;

public class Hotel {
	private String name;
	private int regCustomerWeekdayRate;
	private int regCustomerWeekendRate;
	private int ratings;

	public Hotel(String name, int regCustomerWeekdayRate, int regCustomerWeekendRate, int ratings) {
		this.name = name;
		this.regCustomerWeekdayRate = regCustomerWeekdayRate;
		this.regCustomerWeekendRate = regCustomerWeekendRate;
		this.ratings= ratings;
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
	public int getRatings() {
		return ratings;
	}

	@Override
	public String toString() {
		return "Hotel: " + name + ",\tRegular Customer Weekday Rates: $" + regCustomerWeekdayRate+",\tRegular Customer Weekend Rates"+regCustomerWeekendRate;
	}

}
