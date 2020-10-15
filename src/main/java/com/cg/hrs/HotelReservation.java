package com.cg.hrs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {
	List<Integer> cheapestHotelIndexes;
	List<Hotel> hotels;
	List<Date> dates;

	public HotelReservation() {
		this.cheapestHotelIndexes = new ArrayList<Integer>();
		hotels = new ArrayList<Hotel>();
		dates = new ArrayList<Date>();
	}

	public void enterDates() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dates of Format[ddMMMyyyy(day)]: ");
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy(EEE)");
		while (true) {
			System.out.println("Enter date:");
			String inputDate = sc.next();
			try {
				Date d = dateFormat.parse(inputDate);
				this.dates.add(d);
			} catch (ParseException e) {
				System.out.println("Invalid date input.");
			} finally {
				System.out.println("Want to enter another date:(Y/N)");
				char c = sc.next().charAt(0);
				if (c == 'y' || c == 'Y')
					continue;
				else if (c == 'n' || c == 'N')
					break;
			}
		}
		sc.close();

	}

	public int[] totalRates() {
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

	public void findCheapestHotelIndexes() {
		int[] totalRates1 = totalRates();
		Arrays.sort(totalRates1);
		int lowestRate = totalRates1[0];

		int[] totalRates = totalRates();

		for (int i = 0; i < 3; i++) {
			if (totalRates[i] == lowestRate)
				cheapestHotelIndexes.add(i);
		}

	}

	public int basedOnRating() {
		this.findCheapestHotelIndexes();
		int bestRating = hotels.get(0).getRatings();
		for (Integer i : cheapestHotelIndexes) {
			if (((Integer) hotels.get(i).getRatings()).compareTo((Integer) bestRating) > 0) {
				bestRating = hotels.get(i).getRatings();
			}

		}
		return bestRating;
	}

	public Hotel getBestRatedHotel() {
		int bestRating = hotels.get(0).getRatings();
		for (int i = 0; i < hotels.size(); i++) {
			if (((Integer) hotels.get(i).getRatings()).compareTo((Integer) bestRating) > 0)
				bestRating = hotels.get(i).getRatings();
		}
		for (Hotel h : hotels)
			if (h.getRatings() == bestRating)
				return h;
		return null;
	}

	public void printCheapHotels() {

		int[] totalRates = totalRates();
		int bestRating = this.basedOnRating();
		for (Integer i : cheapestHotelIndexes) {
			if (hotels.get(i).getRatings() == bestRating)
				this.printHotel(hotels.get(i), totalRates[i]);
		}
	}

	public void printHotel(Hotel h, int totalRates) {
		System.out.println(h.getName() + ",\tRating: " + h.getRatings() + ",\tTotal Rates: $" + totalRates);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation Program.");
		HotelReservation reservation = new HotelReservation();
		Hotel lakewood = new Hotel("Lakewood", 110, 90, 3, 80, 80);
		Hotel bridgewood = new Hotel("Bridgewood", 160, 50, 4, 110, 50);
		Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5, 100, 40);
		reservation.hotels.add(lakewood);
		reservation.hotels.add(bridgewood);
		reservation.hotels.add(ridgewood);

		for (int i = 0; i < reservation.hotels.size(); i++)
			System.out.println(reservation.hotels.get(i));
	}

}
