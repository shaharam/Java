package Maman12.question2;

public class HighInterestSavings extends SavingsAccount {
	private double min_balance = 200; //fixed value
	
	public HighInterestSavings(String accountId, String accountName, String ownerId, double balance) {
		super(accountId, accountName, ownerId, balance, 2); //2 = Interest grater than superclass
	}
	
	public HighInterestSavings(String accountId, String accountName, String ownerId, double balance, double min_bal) {
		super(accountId, accountName, ownerId, balance, 2); //2 = Interest grater than superclass
		this.min_balance = min_bal;
	}

	public double getMin_balance() {
		return min_balance;
	}

	public void setMin_balance(double min_balance) {
		this.min_balance = min_balance;
	}
	
	@Override
	public void withdraw(double money) {
		try {
			if ((this.balance - money) < this.min_balance)
				throw new IllegalBalance();
			else
				super.withdraw(money);
		}
		
		catch (IllegalBalance e) {
			System.out.println("Withdraw of " + money + " failed - Balance will be lower than minimum balance");
		}
	}

	@Override
	public String toString() {
		String[] str = super.toString().split(":"); //Removed the name of superclass name
		return "HighInterestSavings:" + str[1] + ", Minimum_balance=" + min_balance + "$";
	}

}
