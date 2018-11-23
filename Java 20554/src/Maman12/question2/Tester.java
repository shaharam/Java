package Maman12.question2;

public class Tester {

	public static void main(String[] args) {
		BankAccount[] accounts = new BankAccount[5];
		accounts[0] = new ServiceChargeChecking("10001", "Shahar", "123456789", 10000, 15);	//Using other service fee (15) 
		accounts[1] = new NoServiceChargeChecking("10002", "Shoshi", "987654321", 2500); //Using default minimum balance (100)
		accounts[2] = new InterestChecking("10003", "Shimon", "777777777", 35000, 1.5);	//Using other interest (1.5)
		accounts[3] = new SavingsAccount("10004", "Shuki", "333333333", 333);	//Using default interest (1.5)
		accounts[4] = new HighInterestSavings("10005", "Shir", "444444444", 5000, 300);	//Using other minimum balance (300)
		
		System.out.println(accounts[0]);
		accounts[0].withdraw(10001);
		System.out.println(accounts[0]);
		accounts[0].deposit(555);
		System.out.println(accounts[0] + "\n\n");
		
		System.out.println(accounts[1]);
		((CheckingAccount) accounts[1]).writeCheck(2450);
		System.out.println(accounts[1]);
		((CheckingAccount) accounts[1]).writeCheck(40);
		System.out.println(accounts[1] + "\n\n");
		
		System.out.println(accounts[2]);
		((NoServiceChargeChecking) accounts[2]).setMin_balance(1000);
		System.out.println(accounts[2]);
		
		
//		System.out.println(accounts[3]);
//		System.out.println(accounts[4] + "\n");
		
	}

}
