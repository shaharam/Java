package Maman15.question2;

import java.util.Random;

public class Main {
	private final static int NUMBER_OF_FLIGHTS = 10;
	private final static int NUMBER_OF_ROUTES = 3;
	
	public static void main(String[] args) {
		Airport[] airports = new Airport[2]; 
		airports[0] = new Airport("TLV", NUMBER_OF_ROUTES);
		airports[1] = new Airport("JFK", NUMBER_OF_ROUTES);
		
		for (int i=0; i<NUMBER_OF_FLIGHTS; i++) {
			Airport fromAirport = airports[new Random().nextInt(airports.length)]; //random on the flight direction
			Airport toAirport = (fromAirport.getAirportName() == "TLV") ? airports[1]: airports[0];
			Flight temp = new Flight(i, fromAirport, toAirport);
			System.out.println("Flight number " + i + " From " + fromAirport.getAirportName() + " To " + toAirport.getAirportName() + " is ready");
			temp.start();
		}
	}

}
