package Maman15.question1;

public class NumbersDB {
	private int numbersToCheck;
	private int concurrentThreads;
    private  boolean[] primeArray;
    private  Controller controller;
	
	public NumbersDB(String[] args) {
		if (args.length != 2) {
            System.err.println("Please enter exactly 2 arguments");
            System.exit(1);
        }
         
		numbersToCheck = Integer.parseInt(args[0]);
		concurrentThreads = Integer.parseInt(args[1]);
     
        if(numbersToCheck < 1 || concurrentThreads < 1) {     
        	System.err.println("Numbers to check or concurrent threads must be greater than 1");
        	System.exit(1);
        }
        initArray();
        
        for(int i=2; i<=numbersToCheck; i++){      
            controller.waitForOneThread();
            new PrimeNum(i, primeArray, controller).start();
        }
        controller.waitForAllThreads();
        printPrime();
	}
	
	private void initArray() {
		primeArray = new boolean[numbersToCheck + 1];
		controller = new Controller(numbersToCheck, concurrentThreads);
		
		//fill the array with 'true' value except the first cell
        for(int i=1; i<=numbersToCheck; i++)
        	primeArray[i] = true;
	}

	public void printPrime() {
		System.out.println("Prime Numbers till " + numbersToCheck + ":\n");
        for(int i=1; i<=numbersToCheck; i++) {
        	if(primeArray[i])
        		System.out.print(" " + i);
        }
	}
}
