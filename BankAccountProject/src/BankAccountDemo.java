import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
Joseph Bollish

Project Name: CSC372-CTA01

Project Purpose:

Algorithm Used: Inheritance is used 
to implement a checking account 
class from a super Banking account class

Program Inputs:

The program will ask for a command whether to deposit an amount, 
withdraw an amount, display account information, 
transaction history, or to quit the program.
The following amounts will be deposited: 22, 27, and 5.50
The following amounts will be withdrawn: 50 and 6.
	
Program Outputs:

The program will display the name on the account, the account ID, 
transaction history, balance, and if the user withdraws too much
the program issues a 30 dollar charge. The program also states an
 invalid command if an invalid command is entered.

Program Limitations:

Program will except negative amounts for deposits when it should not.

Program Errors:

Corrected
Program needed a try-catch block to validate a non-numeric input.

===========================================
*/

public class BankAccountDemo {
	static Checkings checking = new Checkings();
	static DepWthFile theFile = new DepWthFile(); 
	static ArrayList<Double> bankDeposits = new ArrayList<Double>();
	static ArrayList<Double> bankWithdraws = new ArrayList<Double>();
	static Scanner scnr = new Scanner(System.in);
	static String userInput = "";
	static Double deposit = 0.0;
	
	public static void main(String[] args) {
		
		File depositFile = new File("deposit.txt");
		try {
			
			Scanner readDeposit = new Scanner(new File("deposit.txt"));
			while(readDeposit.hasNextDouble()) {
				bankDeposits.add(readDeposit.nextDouble());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
			
		}
		
		try {
			File withdrawFile = new File("withdraw.txt");
			Scanner readWithdraws = new Scanner(new File("withdraw.txt"));
			while(readWithdraws.hasNextDouble()) {
				bankWithdraws.add(readWithdraws.nextDouble());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			File balanceValue = new File("balance.txt");
			Scanner readBalance = new Scanner(new File("balance.txt"));
			while(readBalance.hasNextDouble()) {
				checking.deposit(readBalance.nextDouble());
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		checking.setFirstName("Joseph");
		checking.setLastName("Bollish");
		checking.setAccountID(22333);
		
		// while loop for commands
		while(!(userInput.equals("Quit"))){
			try {
			System.out.println("Enter Command(Deposit/Withdraw/Display/History/Quit) ");
			userInput = scnr.next();
		
			// deposit amount
			if(userInput.equals("Deposit")) {
				System.out.println("Enter deposit amount: ");
				deposit = scnr.nextDouble();
//				if(deposit < 0) {
//					System.out.println("Please enter a valid number");
//				}
				checking.deposit(deposit);
				bankDeposits.add(deposit);	
			}
			
			// withdraw amount
			else if(userInput.equals("Withdraw")) {
				System.out.println("Enter withdraw amount: ");
				deposit = scnr.nextDouble();
				checking.withdraw(deposit);
				bankWithdraws.add(deposit);
					if(checking.getBalance() <= 0) {
						checking.processWithdrawal();
					}
			
			}
			
			// shows account balance, name and number
			else if(userInput.equals("Display")) {
				checking.displayAccount();
			}
			
			// shows transaction history
			else if(userInput.equals("History")) {
				System.out.println("Deposit History");
				for(int i = 0 ; i < bankDeposits.size(); i++) {
				System.out.println(bankDeposits.get(i));
				}
				System.out.println("");
				
				System.out.println("Withdraw History");
				for(int i = 0 ; i < bankWithdraws.size(); i++) {
				System.out.println(bankWithdraws.get(i));
				}
				System.out.println("");
			}
			
			else if (userInput.equals("Quit")) {
				System.out.println("Account Saved");
				theFile.writeFile(bankDeposits,bankWithdraws, checking.getBalance());
				
			}
			
			else {
				System.out.println("Not a valid input");
			}
		}
		catch(Exception exp) {
			
		}
		}
	}
}
