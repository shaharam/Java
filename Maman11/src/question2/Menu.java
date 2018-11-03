package question2;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter the number of monomials in the polynom: ");
		int number = scan.nextInt();
		double[] coefficients = Monomial.initializeArrays(number, "coefficient");
		double[] powers = Monomial.initializeArrays(number, "power");
		Polynom poly = new Polynom(coefficients, powers);		
				
		int choice;
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
				break;
			
			case 2:
				break;
				
			case 3:
				break;
				
			case 4:
				poly.toString();
				break;
			
			case 5:
				break;
				
			case 6:
				System.out.println("CashDesk is close!");
				scan.close();
				System.exit(0);
				
	        default:
	        	System.out.println("Invalid menu choice, try again.");
	            break;
			}
		}while(choice != 6);
	}
}