package Maman12.question2;

public class InterestChecking extends NoServiceChargeChecking {
	private double interest = 2; //fixed value

	public InterestChecking(String accountId, String accountName, String ownerId, double balance) {
		super(accountId, accountName, ownerId, balance, 300); //300 = Greater minimum balance than superclass
	}
	
	public InterestChecking(String accountId, String accountName, String ownerId, double balance, double interest) {
		super(accountId, accountName, ownerId, balance, 300); //300 = Greater minimum balance than superclass
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
	public void monthlyManage() {
		this.deposit(this.interestCalculation()); //Using deposit method
	}

}
