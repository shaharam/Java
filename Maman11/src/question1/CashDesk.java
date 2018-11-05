package question1;
import java.util.ArrayList;

public class CashDesk {
	private static double _cashDeskAmount;
	private double _customerAmount;
	private ArrayList<BillRow> _totalBill = new ArrayList<BillRow>();
	
	public static CashDesk initializeCashDesk(double amount) { //method that call one of the constructors 
		if (amount == 0) {
			return new CashDesk();
		}
		else {
			return new CashDesk(amount);
		}
	}
	
	public CashDesk() {
		super();
		CashDesk._cashDeskAmount = 0;
	}
	
	public CashDesk(double _amount) {
		super();
		CashDesk._cashDeskAmount = _amount;
	}
	
	public void addProduct(Product prdct, int quantity) {
		BillRow bill = new BillRow(prdct, quantity);
		_customerAmount = _customerAmount + bill.get_sum();
		_totalBill.add(bill);
	}
	
	@Override
	public String toString() {
		System.out.println("-------------------------------");
		for(int i=0; i<_totalBill.size(); i++) {
			System.out.println(_totalBill.get(i).get_prdct().get_name() + "\t" + _totalBill.get(i).get_quantity() + "\t" + _totalBill.get(i).get_sum());
		}
		System.out.println("-------------------------------");
		return null;
	}
	
	/**
	 * @return the _customerAmount
	 */
	public void printCustomerAmout() {
		System.out.println("Total bill for customer is: " + _customerAmount);
	}
	
	public void pay(double money) {
		_cashDeskAmount = _cashDeskAmount + _customerAmount;
		System.out.println("The change for customer is: " + (money-_customerAmount));
		_customerAmount = 0;
		_totalBill.clear(); //Clearing the billrow array list and ready for new customer
	}

	/**
	 * @return the _cashDeskAmount
	 */
	public static void printCashDeskAmount() {
		System.out.println("Total amount in cash desk is: " + _cashDeskAmount);
	}
}
