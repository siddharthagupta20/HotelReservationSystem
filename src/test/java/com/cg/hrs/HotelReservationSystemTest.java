package com.cg.hrs;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class HotelReservationSystemTest {
	@Test
	public void givenDatesShouldReturnCheapestHotel() {
		HotelReservation reservation = new HotelReservation();

		Hotel lakewood = new Hotel("Lakewood", 110, 90, 3, 80, 80);
		Hotel bridgewood = new Hotel("Bridgewood", 160, 50, 4, 110, 50);
		Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5, 100, 40);
		reservation.hotels.add(lakewood);
		reservation.hotels.add(bridgewood);
		reservation.hotels.add(ridgewood);
		List<Date> datesList = new ArrayList<>();
		SimpleDateFormat ft = new SimpleDateFormat("ddMMMyyyy(EEE)");
		try {
			datesList.add(ft.parse("18oct2020(sun)"));
			datesList.add(ft.parse("19oct2020(mon)"));
			datesList.add(ft.parse("20oct2020(tue)"));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < 3; i++) {
			reservation.dates.add(datesList.get(i));
		}
		reservation.regular = false;

		assertEquals("Ridgewood,\tRating: 5,\tTotal Rates: $240", reservation.printCheapHotels());

	}

}
