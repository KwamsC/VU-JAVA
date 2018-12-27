package Manny;
import java.util.Scanner;
import java.io.PrintStream;
public class Manny {
	PrintStream out;
	static final double MIN_AMOUNT = 50.00;
	Manny(){
		out = new PrintStream(System.out);
	}
	
	void start(){
		Scanner in = new Scanner(System.in);
		double amount;
		do {
			out.printf("Enter the amount you want to donate: ");
			amount=in.nextDouble();
			
		} while (amount<MIN_AMOUNT);
		out.printf("Thank you very much for your contribution of %.2f euro.", amount) ;
	}
	
	public static void main(String[] args) {
		new Manny().start();
	}
	
}
