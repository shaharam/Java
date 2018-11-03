package question1;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter the initial amount of the cashdesk or '0' if it's empty: ");
		double amount = scan.nextDouble();
		CashDesk cashdesk = CashDesk.initializeCashDesk(amount); //Using static method in order to avoid 'if' in main
				
		int choice;
		do{
			System.out.println("\nEnter Your Menu Choice: ");
			System.out.println("1. Add product");
			System.out.println("2. Check current bill");
			System.out.println("3. Check total price for customer");
			System.out.println("4. Customer pay");
			System.out.println("5. Check total amount in the cashdesk");
			System.out.println("6. Exit\n");

			choice = scan.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter the product name: ");
				String name = scan.next();
				System.out.println("Enter the product price: ");
				double price = scan.nextDouble();
				System.out.println("Enter the product quantity: ");
				int quantity = scan.nextInt();
				Product temp = new Product(name, price);
				cashdesk.addProduct(temp, quantity);
				break;
			
			case 2:
				cashdesk.toString();
				break;
				
			case 3:
				cashdesk.printCustomerAmout();
				break;
				
			case 4:
				cashdesk.printCustomerAmout();
				System.out.println("Enter the amount of money that the customer has paid: ");
				double money = scan.nextDouble();
				cashdesk.pay(money);
				break;
			
			case 5:
				CashDesk.printCashDeskAmount();
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