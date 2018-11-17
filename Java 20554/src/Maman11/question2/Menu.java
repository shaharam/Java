package Maman11.question2;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		System.out.println("Please enter two Polynoms...");
		Polynom pol1 = Polynom.polynomCreation("1st");
		Polynom pol2 = Polynom.polynomCreation("2nd");
				
		int choice;
		Scanner scan = new Scanner (System.in);
		do{
			System.out.println("\nEnter Your Menu Choice: ");
			System.out.println("1. Plus");
			System.out.println("2. Minus");
			System.out.println("3. Gzira");
			System.out.println("4. Print the polynom");
			System.out.println("5. Compare polynoms");
			System.out.println("6. Exit\n");

			choice = scan.nextInt();
			switch(choice){
			case 1:
				Polynom plusResult = pol1.plus(pol2);
				plusResult.toString();
				break;
			
			case 2:
				Polynom minusResult = pol1.minus(pol2);
				minusResult.toString();
				break;
				
			case 3:
				pol1.gzira();
				pol2.gzira();
				break;
				
			case 4:
				pol1.toString();
				pol2.toString();
				break;
			
			case 5:
				int result = pol1.compareTo(pol2);
				System.out.println("Result of compare: " + result);
				break;
				
			case 6:
				System.out.println("Exiting program...");
				scan.close();
				System.exit(0);
				
	        default:
	        	System.out.println("Invalid menu choice, try again.");
	            break;
			}
		}while(choice != 6);
	}
}