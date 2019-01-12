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
		takeoffLand("Take off");
		fromAirport.freeRunway(flightNumber, route);
		flight();
		route = toAirport.land(flightNumber);
		takeoffLand("Land");
		toAirport.freeRunway(flightNumber, route);
	}
	
	//method for take off or land with random time between minTakeoffLandTime to maxTakeoffLandTime seconds
	private void takeoffLand(String direction) {
		int duration = (int)(Math.random() * ((maxTakeoffLandTime - minTakeoffLandTime) + 1)) + minTakeoffLandTime;
		System.out.println("Flight number " + flightNumber + " - " + direction + " duration: " + duration);
		try {
			Thread.sleep(duration * 1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
			e.printStackTrace();
		}
	}
	
	//method for take off or land with random time between minFlightTime to maxFlightTime seconds
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

	public Airport getFromAirport() {
		return fromAirport;
	}

	public Airport getToAirport() {
		return toAirport;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setFromAirport(Airport fromAirport) {
		this.fromAirport = fromAirport;
	}

	public void setToAirport(Airport toAirport) {
		this.toAirport = toAirport;
	}
	
}
