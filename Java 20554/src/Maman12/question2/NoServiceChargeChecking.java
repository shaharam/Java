package Maman12.question2;

public class NoServiceChargeChecking extends CheckingAccount {
	private double min_balance = 100; //fixed value
	
	public NoServiceChargeChecking(String accountId, String accountName, String ownerId, double balance) {
		super(accountId, accountName, ownerId, balance);
	}
	
	public NoServiceChargeChecking(String accountId, String accountName, String ownerId, double balance, double min_bal) {
		super(accountId, accountName, ownerId, balance);
		this.min_balance = min_bal;
	}

	public double getMin_balance() {
		return this.min_balance;
	}

	public void setMin_balance(double min_balance) {
		this.min_balance = min_balance;
	}

	@Override
	public void monthlyManage() {}	//No need to implement but must to override as it's an abstract method

}
