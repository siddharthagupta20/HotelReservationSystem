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
		Hotel lakewood = new Hotel("Lakewood", 110);
		Hotel bridgewood = new Hotel("Bridgewood", 160);
		Hotel ridgewood = new Hotel("Ridgewood", 220);
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(lakewood);
		hotels.add(bridgewood);
		hotels.add(ridgewood);
		HotelReservation reservation = new HotelReservation();
		
		List<Date> datesList=new ArrayList<>();
		SimpleDateFormat ft=new SimpleDateFormat("ddMMMyyyy(EEE)");
		try {
		datesList.add(ft.parse("18oct2020(sun)"));
		datesList.add(ft.parse("19oct2020(mon)"));
		datesList.add(ft.parse("20oct2020(sat)"));
		}
		catch(ParseException e) {
			System.out.println(e.getMessage());
		}
		assertEquals("Lakewood,\tTotal Rates: $300",reservation.findCheapestHotel(hotels, datesList));
	}

}
