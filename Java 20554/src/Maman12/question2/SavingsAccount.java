package Maman12.question2;

public class SavingsAccount extends BankAccount {
	private double interest = 1.5; //fixed value
	
	public SavingsAccount(String accountId, String accountName, String ownerId, double balance) {
		super(accountId, accountName, ownerId, balance);
	}
	
	public SavingsAccount(String accountId, String accountName, String ownerId, double balance, double interest) {
		super(accountId, accountName, ownerId, balance);
		this.interest = interest;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	private double interestCalculation() {
		return ((this.balance * this.interest) / 100) / 12; //Divide by 12 in order to get the interest per month
	}

	@Override
	public String toString() {
		return "SavingsAccount: " + super.toString() + ", Interest=" + interest + "%";
	}

	@Override
	public void monthlyManage() {
		System.out.print("Monthly manage: ");
		this.deposit(this.interestCalculation()); //Using deposit method
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof SavingsAccount))
			return false;
		SavingsAccount temp = (SavingsAccount)other;
		return super.equals(other) && this.interest == temp.interest;
	}
}
