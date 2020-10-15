package com.cg.hrs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class HotelReservation {
	List<Integer> cheapestHotelIndexes;
	List<Hotel> hotels;
	List<Date> dates;
	boolean regular;
	Scanner sc;

	public HotelReservation() {
		this.cheapestHotelIndexes = new ArrayList<Integer>();
		hotels = new ArrayList<Hotel>();
		dates = new ArrayList<Date>();
		regular = true;
		sc = new Scanner(System.in);
	}

	public void enterDates() {

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

	}

	public void getCustomerType() {
		while (true) {
			try {
				System.out.println("Enter customer type(Regular/Reward):");
				String type = this.sc.next();
				if (type.toLowerCase().contains("regular")) {
					this.regular = true;
					break;
				} else if (type.toLowerCase().contains("reward")) {
					this.regular = false;
					break;
				} else
					throw new CustomerTypeException("Not a valid customer type.");
			} catch (CustomerTypeException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public int[] totalRates() {
		SimpleDateFormat day = new SimpleDateFormat("EEE");
		int totalRates[] = new int[3];
		int index = 0;
		if (regular) {
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
		} else {
			for (Hotel h : hotels) {
				totalRates[index] = 0;
				for (Date d : dates) {
					if (day.format(d).equalsIgnoreCase("sat") || day.format(d).equalsIgnoreCase("sun"))
						totalRates[index] += h.getSpecialWeekendRates();
					else
						totalRates[index] += h.getSpecialWeekdayRates();
				}
				index++;
			}
		}
		return totalRates;

	}

	public void findCheapestHotelIndexes() {
		int[] totalRates1 = totalRates();
		int lowestRate=Arrays.stream(totalRates1).sorted().findFirst().orElse(0);

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
		return hotels.stream().max(Comparator.comparing(Hotel::getRatings)).orElse(null);
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
		reservation.getCustomerType();
		reservation.enterDates();
		reservation.printCheapHotels();
	}

}
