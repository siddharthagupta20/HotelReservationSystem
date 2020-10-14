package com.cg.hrs;

public class HotelReservation {

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation Program.");
		
		Hotel lakewood= new Hotel("Lakewood",110);
		Hotel bridgewood=new Hotel("Bridgewood",160);
		Hotel ridgewood=new Hotel("Ridgewood", 220);
		
		System.out.println(lakewood);
		System.out.println(bridgewood);
		System.out.println(ridgewood);
	}

}
