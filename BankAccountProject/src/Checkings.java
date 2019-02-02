
public class Checkings extends Account {
	private final double INTEREST_RATE = 0.05;
	
	public void processWithdrawal() {
		balance = balance - 30;
		System.out.println("Overdraft fee, 30 dollar charge.");
		System.out.println("Balance: " + balance);
	}
	
	public void displayAccount(){
		super.accountSummary();
		System.out.println("Interest rate of: " + INTEREST_RATE);
	}
	
	

}
