package Maman12.question2;

public class ServiceChargeChecking extends CheckingAccount {
	
	private final int FIXED_FEE = 10;
	private int fee;
	
	public ServiceChargeChecking(String accountId, String accountName, String ownerId, double balance) {
		super(accountId, accountName, ownerId, balance);
		
		this.fee = FIXED_FEE;
	}
	
	public ServiceChargeChecking(String accountId, String accountName, String ownerId, double balance, int fee) {
		super(accountId, accountName, ownerId, balance);
		
		this.fee = fee;
	}

	public int getFee() {
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
