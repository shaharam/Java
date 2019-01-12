package Maman15.question2;

public class Flight extends Thread {
	private int flightNumber;
	private Airport fromAirport;
	private Airport toAirport;
	private final int minTakeoffLandTime = 2;
	private final int maxTakeoffLandTime = 5;
	private final int minFlightTime = 5;
	private final int maxFlightTime = 10;
	
	public Flight(int flightNumber, Airport fromAirport, Airport toAirport) {
		super();
		this.flightNumber = flightNumber;
		this.fromAirport = fromAirport;
		this.toAirport = toAirport;
	}
	
	public void run() {
		int route = fromAirport.depart(flightNumber);
		takeoffLand("From", fromAirport.getAirportName(), route, "Take off");
		fromAirport.freeRunway(flightNumber, route);
		flight();
		route = toAirport.land(flightNumber);
		takeoffLand("To", toAirport.getAirportName(), route, "Land");
		toAirport.freeRunway(flightNumber, route);
	}
	
	//method for take off or land with random time between minTakeoffLandTime to maxTakeoffLandTime seconds
	private void takeoffLand(String direction, String airport, int route, String action) {
		int duration = (int)(Math.random() * ((maxTakeoffLandTime - minTakeoffLandTime) + 1)) + minTakeoffLandTime;
		System.out.println("Flight number " + flightNumber + " - " + direction + " " + airport + " route: " + route + " - " + action + " duration: " + duration);
		try {
			Thread.sleep(duration * 1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
			e.printStackTrace();
		}
	}
	
	//method for flight with random time between minFlightTime to maxFlightTime seconds
	private void flight() {
		int duration = (int)(Math.random() * ((maxFlightTime - minFlightTime) + 1)) + minFlightTime;
		System.out.println("Flight number " + flightNumber + " - " + "Flight duration: " + duration);
		try {
			Thread.sleep(duration * 1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
			e.printStackTrace();
		}
	}
	
	public int getFlightNumber() {
		return flightNumber;
	}

}
