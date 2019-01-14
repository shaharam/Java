package Maman15.question1;

public class Controller {
	private int numbersToCheck;
	private int concurrentThreads;
	private int currentThreads;
    
    public Controller(int numbersToCheck, int concurrentThreads) {
        this.numbersToCheck = numbersToCheck;
        this.concurrentThreads = concurrentThreads;
        currentThreads = 0;
    }

    public synchronized void finished(){
    	currentThreads--;     
    	notify();
    }
    
    public synchronized void waitForOneThread(){
	    try {
	        while(currentThreads == concurrentThreads) {
	        	wait();
	        }
	        currentThreads++;
	    }
	    
	    catch(InterruptedException e) {
	        System.out.println("Interrupted");
	    }
     }
    
    public synchronized void waitForAllThreads(){
         try {
	        while(currentThreads > 0) {
	        	wait();
	        }
         }
         
     	catch(InterruptedException e) {
                System.out.println("Interrupted");
        }
    }
    
}
