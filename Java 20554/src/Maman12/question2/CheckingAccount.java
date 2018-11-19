package Maman12.question2;

public abstract class CheckingAccount extends BankAccount {

	public CheckingAccount(String accountId, String accountName, String ownerId, double balance) {
		super(accountId, accountName, ownerId, balance);
	}
	
	public void writeCheck(double check) {
		this.withdraw(check);
	}
}
