package Maman15.question1;

public class PrimeNum extends Thread {
	private String name;
	private boolean finished;
	
	public PrimeNum(String n) {
		this.name = name;
		this.finished = false;
	}
	
	public void run() {
		int num = NumbersDB.getNumberForCheck();
		if (num == -1)
			finished = true;
		else if (checkIfPrime(num))
			NumbersDB.numbers.get(num).setPrime(true);
	}

	private boolean checkIfPrime(int num) {
		for(int i=2;2*i<num;i++) {
	        if(num%i==0)
	            return false;
	    }
	    return true;
	}
	
	public boolean isFinished() {
		return finished;
	}
}
