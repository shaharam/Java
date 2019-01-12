package Maman15.question2;

public class Airport {
	private String airportName;
	private int routesNumber;
	
	public Airport(String airportName, int routesNumber) {
		this.airportName = airportName;
		this.routesNumber = routesNumber;
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

	public int getRoutes() {
		return routesNumber;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public void setRoutes(int routes) {
		this.routesNumber = routes;
	}
}

