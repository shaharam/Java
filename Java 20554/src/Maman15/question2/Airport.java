package Maman15.question2;

public class Airport {
	private String airportName;
	private int[] routes;
	
	public Airport(String airportName, int routesNumber) {
		this.airportName = airportName;
		this.routes = new int[routesNumber];
	}
	
	public int depart(int flightNum) {
		int freeRoute = 0; //TODO fix this func
		return freeRoute;
	}
	
	public int land(int flightNum) {
		int freeRoute = 0; //TODO fix this func
		return freeRoute;
	}
	
	public void freeRunway(int flightNum, int route) {
		
	}

	public String getAirportName() {
		return airportName;
	}

	public int[] getRoutes() {
		return routes;
	}
}

