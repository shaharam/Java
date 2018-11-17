package Maman12.question2;

public abstract class BankAccount {
	private String accountId;
	private String accountName;
	private String ownerId;
	private double balance;
	
	public BankAccount(String accountId, String accountName, String ownerId, double balance) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.ownerId = ownerId;
		this.balance = balance;
	}
	
	public void deposit(double money) {
		balance += money;
	}
	
	public void withdraw(double money) {
		try {
			if (balance < money)
				throw new IllegalBalance();
			else
				balance -= money;
		}
		
		catch (IllegalBalance e) {
			System.out.println("Insufficient funds");
		}
		
		balance = balance - money;
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

