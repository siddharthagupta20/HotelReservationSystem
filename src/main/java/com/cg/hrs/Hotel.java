package com.cg.hrs;

public class Hotel {
	private String name;
	private int regCustomerWeekdayRate;
	private int regCustomerWeekendRate;
	private int ratings;
	private int specialWeekdayRates;
	private int specialWeekendRates;

	public Hotel(String name, int regCustomerWeekdayRate, int regCustomerWeekendRate, int ratings,
			int specialWeekdayRates, int specialWeekendRates) {
		this.name = name;
		this.regCustomerWeekdayRate = regCustomerWeekdayRate;
		this.regCustomerWeekendRate = regCustomerWeekendRate;
		this.ratings = ratings;
		this.specialWeekdayRates = specialWeekdayRates;
		this.specialWeekendRates = specialWeekendRates;
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

	public int getSpecialWeekdayRates() {
		return specialWeekdayRates;
	}

	public int getSpecialWeekendRates() {
		return specialWeekendRates;
	}

	@Override
	public String toString() {
		return "Hotel: " + name + ",\tRegular Customer Weekday Rates: $" + regCustomerWeekdayRate
				+ ",\tRegular Customer Weekend Rates" + regCustomerWeekendRate+",\tRatings: "+ratings+",\tSpecial Weekday Rates: "+specialWeekdayRates+",\tSpecial Weeekend Rates: "+specialWeekendRates;
	}

}
