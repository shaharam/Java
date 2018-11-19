package Maman12.question2;

public class NoServiceChargeChecking extends CheckingAccount {
	
	private final double MIN_BALANCE = 100;
	private double min_balance;
	
	public NoServiceChargeChecking(String accountId, String accountName, String ownerId, double balance) {
		super(accountId, accountName, ownerId, balance);
		
		this.min_balance = MIN_BALANCE;
	}
	
	public NoServiceChargeChecking(String accountId, String accountName, String ownerId, double balance, double min_bal) {
		super(accountId, accountName, ownerId, balance);
		
		this.min_balance = min_bal;
	}

	public double getMin_balance() {
		return min_balance;
	}

	public void setMin_balance(double min_balance) {
		this.min_balance = min_balance;
	}

	@Override
	public void monthlyManage() {}

}
