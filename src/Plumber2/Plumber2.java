package Plumber2;
import java.util.Scanner;
import java.io.PrintStream;
public class Plumber2 {
	PrintStream out;
	static final double WAGES = 31.50;
	static final double CALL_OUT_COST = 16.00;
	Plumber2() {
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
	    
	   	out.printf("Enter the number of billable hours: ");
	   	double billHours = Math.round(in.nextDouble());
	   	
	   	
	   	double costRepair = WAGES
	    	    * billHours + CALL_OUT_COST;
	   	
	   	out.printf(" \n The total cost of this repair is: %.2f ",
	   			costRepair);
	}
	
	public static void main(String[] argv) {
	    new Plumber2().start();
	}
}
