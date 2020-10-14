package com.cg.hrs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {
	List<Integer> indexes;

	public HotelReservation() {
		this.indexes = new ArrayList<Integer>();
	}

	public int[] totalRates(List<Hotel> hotels, List<Date> dates) {
		SimpleDateFormat day = new SimpleDateFormat("EEE");
		int totalRates[] = new int[3];
		int index = 0;
		for (Hotel h : hotels) {
			totalRates[index] = 0;
			for (Date d : dates) {
				if (day.format(d).equalsIgnoreCase("sat") || day.format(d).equalsIgnoreCase("sun"))
					totalRates[index] += h.getRegCustomerWeekendRate();
				else
					totalRates[index] += h.getRegCustomerWeekdayRate();
			}
			index++;
		}
		return totalRates;

	}

	public List<Integer> findCheapestHotelIndexes(List<Hotel> hotels, List<Date> dates) {
		int[] totalRates1 = totalRates(hotels, dates);
		Arrays.sort(totalRates1);
		int lowestRate = totalRates1[0];

		int[] totalRates = totalRates(hotels, dates);

		for (int i = 1; i < 3; i++) {
			if (totalRates[i] == lowestRate)
				indexes.add(i);
		}
		return indexes;
	}

	public void printHotels(List<Hotel> hotels, List<Date> dates) {

		int[] totalRates = totalRates(hotels, dates);
		for (int i = 0; i < 3; i++) {
			for (Integer j : indexes) {
				if (i == j)
					System.out.println(hotels.get(i).getName() + ",\tRating: " + hotels.get(i).getRatings()
							+ ",\tTotal Rates: $" + totalRates[i]);
			}
		}
	}

	@SuppressWarnings("finally")
	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation Program.");

		Hotel lakewood = new Hotel("Lakewood", 110, 90, 3);
		Hotel bridgewood = new Hotel("Bridgewood", 160, 50, 4);
		Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5);
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
				else if (c == 'n' || c == 'N')
					break;
				else {
					System.out.println("Invalid choice.");
					break;
				}

			}
		}
		reservation.printHotels(hotels, dates);

		sc.close();
	}

}
