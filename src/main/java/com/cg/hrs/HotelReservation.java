package com.cg.hrs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {

	public String findCheapestHotel(List<Hotel> hotels, List<Date> dates) {
		return hotels.get(0).getName() + ",\tTotal Rates: $" + hotels.get(0).getRegCustomerWeekdayRate() * dates.size();

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
				dates.add(dateFormat.parse(inputDate));
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
