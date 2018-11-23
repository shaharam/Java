package Maman12.question2;

public class ServiceChargeChecking extends CheckingAccount {
	private double fee = 10; //fixed value
	
	public ServiceChargeChecking(String accountId, String accountName, String ownerId, double balance) {
		super(accountId, accountName, ownerId, balance);
	}
	
	public ServiceChargeChecking(String accountId, String accountName, String ownerId, double balance, int fee) {
		super(accountId, accountName, ownerId, balance);
		this.fee = fee;
	}

	public double getFee() {
		return this.fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public void monthlyManage() {
		this.withdraw(this.fee);
	}
}
