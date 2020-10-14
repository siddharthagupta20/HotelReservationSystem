package com.cg.hrs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {

	public String findCheapestHotel(List<Hotel> hotels, List<Date> dates) {
		Integer lowestRates = 1999999999;
		SimpleDateFormat day = new SimpleDateFormat("EEE");
		for (Hotel h : hotels) {
			int totalRates = 0;
			for (Date d : dates) {
				if (day.format(d).equalsIgnoreCase("sat") || day.format(d).equalsIgnoreCase("sun"))
					totalRates += h.getRegCustomerWeekendRate();
				else
					totalRates += h.getRegCustomerWeekdayRate();
			}
			if (lowestRates.compareTo(totalRates) > 0)
				lowestRates = totalRates;
		}
		return hotels.get(0).getName() + ",\tTotal Rates: $" + lowestRates;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation Program.");

		Hotel lakewood = new Hotel("Lakewood", 110, 90);
		Hotel bridgewood = new Hotel("Bridgewood", 160, 50);
		Hotel ridgewood = new Hotel("Ridgewood", 220, 150);
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(lakewood);
		hotels.add(bridgewood);
		hotels.add(ridgewood);
		HotelReservation reservation = new HotelReservation();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dates of Format[ddMMMyyyy(day)]: ");
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy(EEE)");
		List<Date> dates = new ArrayList<Date>();
		while (true) {
			System.out.println("Enter date:");
			String inputDate = sc.next();
			try {
				Date d = dateFormat.parse(inputDate);
				dates.add(d);
			} catch (ParseException e) {
				System.out.println("Invalid date input.");
			} finally {
				System.out.println("Want to enter another date:(Y/N)");
				char c = sc.next().charAt(0);
				if (c == 'y' || c == 'Y')
					continue;
				if (c == 'n' || c == 'N')
					break;
			}
		}
		System.out.println(reservation.findCheapestHotel(hotels, dates));
		sc.close();
	}

}
