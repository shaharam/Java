package Maman15.question2;

import java.util.concurrent.locks.*;

public class Airport {
	private String airportName;
	private int[] routes;
	private Lock lock = new ReentrantLock(true);
	Condition cond = lock.newCondition();
	private Boolean freeRoute;
	
	public Airport(String airportName, int routesNumber) {
		this.airportName = airportName;
		this.routes = new int[routesNumber];
		this.freeRoute = true;
	}
	
	public int depart(int flightNum) {
		lock.lock();
		try {
			return freeRoute(flightNum);
		}
		finally {
			lock.unlock();
		}
	}
	
	private int freeRoute(int flightNum) {
		for (int i=0; i<routes.length; i++) {
			if (routes[i] == 0) { //0 = free route
				routes[i] = flightNum;
				return i;
			}
		this.freeRoute = false;
		
		}
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

