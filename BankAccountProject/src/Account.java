
public class Account {
	private String firstName;
	private String lastName;
	private int accountID;
	protected double balance;
	
	//constructor
	public Account() {
		balance = 0.0;
	}
	
	//deposit
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	//withdraw
	public void withdraw(double amount) {
		balance = balance - amount;
	}
	
	//setters
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setAccountID(int accountID){
		this.accountID = accountID;
	}
	
	//getters
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public int getAccountID(){
		return accountID;
	}
	
	//get balance
	public double getBalance(){
		return balance;
	}
	
	//print account summary
	public void accountSummary(){
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Account ID: " + accountID);
		System.out.print("Balance: ");
		System.out.printf("%.2f\n",  balance);
	}


}
