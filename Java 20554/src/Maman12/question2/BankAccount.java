package Maman12.question2;

public abstract class BankAccount {
	protected String accountId;
	protected String accountName;
	protected String ownerId;
	protected double balance;
	
	public BankAccount(String accountId, String accountName, String ownerId, double balance) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.ownerId = ownerId;
		this.balance = balance;
	}
	
	public void deposit(double money) {
		try {
			if (money <= 0)
				throw new IllegalArgumentException();
			else {
				this.balance += money;
				System.out.println("Deposit of " + money + "$ " + "added to the balance");
			}
		}
		
		catch (IllegalArgumentException e) {
			System.out.println("You Can not deposit this amount of money, please deposit more than 0");
		}
	}
	
	public void withdraw(double money) {
		try {
			if (this.balance < money)
				throw new IllegalBalance();
			else
				this.balance -= money;
				System.out.println("Withdraw of " + money + "$ " + "reduced from the balance");
		}
		
		catch (IllegalBalance e) {
			System.out.println("Withdraw failed - Insufficient funds in the bank");
		}
	}
	
	public abstract void monthlyManage();
	
	@Override
	public String toString() {
		return "AccountId=" + accountId + ", AccountName=" + accountName + ", OwnerId=" + ownerId
				+ ", Balance=" + balance + "$";
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof BankAccount))
			return false;
		BankAccount temp = (BankAccount)other;
		return this.accountId == temp.accountId && this.accountName == temp.accountName && this.ownerId == temp.ownerId && this.balance == temp.balance;
	}

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @return the ownerId
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	
}