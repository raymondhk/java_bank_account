
public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount user1 = new BankAccount(100.00);
		user1.getCheckingBalance();
		user1.getSavingsBalance();
		user1.transfer("checking", "savings", 50.00);
	}
}
