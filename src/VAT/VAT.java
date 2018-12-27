package VAT;
import java.util.Scanner;
import java.io.PrintStream;
public class VAT {
	static final double VAT_PERCENTAGE = 1.21;
	PrintStream out;
	VAT() {
		out = new PrintStream(System.out);
	}
	    
	void start() {
	    Scanner in = new Scanner(System.in);
	    
	    out.printf("Enter the price of an article including VAT: ");
	   	double basePrice = in.nextDouble();

	   	double endPrice = basePrice / VAT_PERCENTAGE;
	    	
	   	out.printf("This article will cost %.2f euro without 21%% \n", endPrice);
	    }
	    	    
	public static void main(String[] argv) {
		new VAT().start();
	}     	    
}
