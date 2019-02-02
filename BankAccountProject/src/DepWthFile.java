
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class DepWthFile {
	private ArrayList<Double> bankDeposits = new ArrayList<Double>();
	private ArrayList<Double> bankWithdraws = new ArrayList<Double>();
	
	
	public void writeFile(ArrayList<Double> deposit, ArrayList<Double> withdraw, double balance ) {
		File depositFile = new File("deposit.txt");
		try {
			FileWriter fwd = new FileWriter(depositFile);
			Writer depositInput = new BufferedWriter(fwd);
			for(int i = 0; i < deposit.size(); ++i) {
				depositInput.write(deposit.get(i).toString() + " ");
			}
			depositInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		File withdrawFile = new File("withdraw.txt");
		try {
			FileWriter fww = new FileWriter(withdrawFile);
			Writer withdrawInput = new BufferedWriter(fww);
			for(int i = 0; i < withdraw.size(); ++i) {
				withdrawInput.write(withdraw.get(i).toString() + " ");
			}
			withdrawInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File balanceValue = new File("balance.txt");
		try {
			FileWriter fwb = new FileWriter(balanceValue);
			Writer lastBalance = new BufferedWriter(fwb);
			lastBalance.write(Double.toString(balance));
			lastBalance.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
