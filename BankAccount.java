import java.util.Random;
public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int accountsCreated;
	private static int totalMoney;
	
	public BankAccount(double num) {
		this.accountNumber = generateAccount();
		this.checkingBalance = num;
		totalMoney += num;
		accountsCreated++;
	}
	
	public BankAccount() {
		this.accountNumber = generateAccount();
		accountsCreated++;
	}
	
	public void getCheckingBalance() {
		System.out.println("Total amount in your checking account: $" + this.checkingBalance);
	}
	
	public void getSavingsBalance() {
		System.out.println("Total amount in your savings account: $" + this.savingsBalance);
	}
	
	public void getTotalBalance() {
		double total = this.checkingBalance + this.savingsBalance;
		System.out.println("Total amount in checking and savings: $" + total);
	}
	
	public void depositChecking(double num) {
		this.checkingBalance += num;
		totalMoney += num;
		System.out.println("You have successfully deposited: $" + num);
		System.out.println("Total amount in your checking account: $" + this.checkingBalance);
	}
	
	public void depositSaving(double num) {
		this.savingsBalance += num;
		totalMoney += num;
		System.out.println("You have successfully deposited: $" + num);
		System.out.println("Total amount in your savings account: $" + this.savingsBalance);
	}
	
	public void withdrawChecking(double num) {
		if(this.checkingBalance > num) {
			this.checkingBalance -= num;
			totalMoney -= num;
			System.out.println("Amount withdrawn: $" + num);
			System.out.println("Total amount in your checking account: $" + this.checkingBalance);
		} else {
			System.out.println("You have insufficient funds...");
		}
	}
	
	public void withdrawSavings(double num) {
		if(this.savingsBalance > num) {
			this.savingsBalance -= num;
			totalMoney -= num;
			System.out.println("Amount withdrawn: $" + num);
			System.out.println("Total amount in your savings account: $" + this.savingsBalance);
		} else {
			System.out.println("You have insufficient funds...");
		}
	}
	
	public void transfer(String str1, String str2, double num) {
		if(str1.toLowerCase() == "checking" && str2.toLowerCase() == "savings" && this.checkingBalance > num) {
			this.checkingBalance -= num;
			this.savingsBalance += num;
			System.out.println("You have successfully transferred $" + num + " from checking to savings");
			System.out.println("Total amount in your checking account: $" + this.checkingBalance);
			System.out.println("Total amount in your savings account: $" + this.savingsBalance);
		} 
		else if(str1.toLowerCase() == "savings" && str2.toLowerCase() == "checking" && this.savingsBalance > num) {
			this.checkingBalance += num;
			this.savingsBalance -= num;
			System.out.println("You have successfully transferred $" + num + " from savings to checking");
			System.out.println("Total amount in your checking account: $" + this.checkingBalance);
			System.out.println("Total amount in your savings account: $" + this.savingsBalance);
		} else {
			System.out.println("Error...Please try again");
		}
	}
	
	private String generateAccount() {
		Random rand = new Random();
		String newStr = "";
		for(int i = 0; i < 10; i ++) {
			newStr += rand.nextInt(10);
		}
		return newStr;
	}

}
