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
			return getFreeRoute(flightNum);
		}
		finally {
			lock.unlock();
		}
	}
	
	public int land(int flightNum) {
		lock.lock();
		try {
			return getFreeRoute(flightNum);
		}
		finally {
			lock.unlock();
		}
	}
	
	private int getFreeRoute(int flightNum) {
		try {
			while (!freeRoute) {
				cond.await();
			}
		}
		catch (InterruptedException e) {
			System.out.println("Interrupted");
			e.printStackTrace();
			lock.unlock();
		}
		
		for (int i=0; i<routes.length; i++) {
			if (routes[i] == 0) { //0 => free route
				routes[i] = flightNum;
				this.freeRoute = (routes[0] != 0 && routes[1] != 0 && routes[2] != 0) ? false: true;
				cond.signalAll();
				return i;
			}
		}
		return -1;
	}
	
	public void freeRunway(int flightNum, int route) {
		lock.lock();
		this.routes[route] = 0;
		this.freeRoute = true;
		lock.unlock();
	}

	public String getAirportName() {
		return airportName;
	}
}
