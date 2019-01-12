package Maman15.question1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumbersDB {
	private int numbersToCheck;
	private static int concurrentThreads;
	private static PrimeNum[] threads;
	protected static ArrayList<Number> numbers = new ArrayList<Number>();
	
	public NumbersDB() {
		super();
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the number you want to check up to which are prime numbers: ");
			this.numbersToCheck = scan.nextInt();
			System.out.println("Enter the number of concurrent threads: ");
			NumbersDB.concurrentThreads = scan.nextInt();
			for (int i=0; i<this.numbersToCheck+1; i++) {
				numbers.add(new Number());
			}
			scan.close();
			threads = new PrimeNum[concurrentThreads];
			for (int i=0; i<concurrentThreads; i++) {
				threads[i] = new PrimeNum("" + i);
				threads[i].start();
			}
		}		
		catch(InputMismatchException e) {
			System.out.println("Wrong input, please run again using integers only");
		}
	}
	
	public static int getNumberForCheck() {
		for (int i=0; i<numbers.size(); i++) {
			if (numbers.get(i).isChecked())
				continue;
			else
				numbers.get(i).setChecked(true);
				return i;
		}
		return -1;
	}
	
	public void printPrime() {
		boolean done = false;
		while (!done) {
			for (int i=0; i<threads.length; i++) {
				if (!threads[i].isFinished())
					break;
				else
					done = true;
			}
		}
		System.out.println("[");
		for (int i=0; i<numbers.size(); i++) {
			if (numbers.get(i).isPrime())
				System.out.println(numbers.get(i) + ", ");
		}
		System.out.println("]");
	}
}

