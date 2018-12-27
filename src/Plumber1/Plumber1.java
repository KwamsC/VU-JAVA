package Plumber1;
import java.util.Scanner;
import java.io.PrintStream;
public class Plumber1 {
	PrintStream out;
	static final double CALL_OUT_COST = 16.00;
	Plumber1() {
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
	    
	    out.printf("Enter the hourly wages: ");
	    double wages = in.nextDouble();
	    
	   	out.printf("Enter the number of billable hours: ");
	   	int billHours = in.nextInt();
	   	
	   	double costRepair = wages
	    	    * billHours + CALL_OUT_COST;
	   	
	   	out.printf("The total cost of this repair is: € %.2f ",
	   			costRepair);
	}
	
	public static void main(String[] argv) {
	    new Plumber1().start();
	}
}

