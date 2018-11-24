package Maman12.question2;

public class InterestChecking extends NoServiceChargeChecking {
	private double interest = 2; //fixed value

	public InterestChecking(String accountId, String accountName, String ownerId, double balance) {
		super(accountId, accountName, ownerId, balance, 300); //300 = Minimum balance grater than superclass
	}
	
	public InterestChecking(String accountId, String accountName, String ownerId, double balance, double interest) {
		super(accountId, accountName, ownerId, balance, 300); //300 = Minimum balance grater than superclass
		this.interest = interest;
	}
	
	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
		System.out.println("Intereset is updated to " + interest);
	}
	
	private double interestCalculation() {
		return ((this.balance * this.interest) / 100) / 12; //Divide by 12 in order to get the interest per month
	}

	@Override
	public String toString() {
		String[] str = super.toString().split(":"); //Removed the name of superclass name 
		return "InterestChecking:" + str[1] + ", Interest=" + interest + "%";
	}

	@Override
	public void monthlyManage() {
		System.out.print("Monthly manage: ");
		this.deposit(this.interestCalculation()); //Using deposit method
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof InterestChecking))
			return false;
		InterestChecking temp = (InterestChecking)other;
		return super.equals(other) && this.interest == temp.interest;
	}

}
