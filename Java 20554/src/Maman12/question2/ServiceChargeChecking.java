package Maman12.question2;

public class ServiceChargeChecking extends CheckingAccount {
	
	private final double FIXED_FEE = 10;
	private double fee;
	
	public ServiceChargeChecking(String accountId, String accountName, String ownerId, double balance) {
		super(accountId, accountName, ownerId, balance);
		
		this.fee = FIXED_FEE;
	}
	
	public ServiceChargeChecking(String accountId, String accountName, String ownerId, double balance, int fee) {
		super(accountId, accountName, ownerId, balance);
		
		this.fee = fee;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public void monthlyManage() {
		this.withdraw(this.fee);
	}
}
