package Maman15.question1;

public class PrimeNum extends Thread {
	private int num;
	private boolean primeArray[];
    private Controller controller;
	
	public PrimeNum(int num, boolean arr[], Controller cntrlr) {
		this.num = num;
	    this.primeArray = arr;
	    this.controller = cntrlr;
	}
	
	public void run() {
		for(int i=2; i<=Math.sqrt(num); i++) {
	        if(num%i==0) {
	        	primeArray[num] = false;
	        }
		}
	    controller.finished();
	}
}
