package Electronics;
import java.util.Scanner;
import java.io.PrintStream;
public class Electronics {
	static final double REDUCTION = 0.15;
	double discountPrice;
	PrintStream out;
	Electronics(){
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		
		out.printf("Enter the price of the first article: ");
	    double first = in.nextDouble();
	    
	    out.printf("Enter the price of the second article: ");
	    double second = in.nextDouble();
		
	    out.printf("Enter the price of the third article: ");
	    double third = in.nextDouble();
	    
	    
	    if (first >= second && first >= third){
	    	discountPrice = first;
	    } else {
	    	if (second >= first && second >= third){
	    	discountPrice = second;
	    	} else{
	    	discountPrice = third;
	    	}
	    }
	    
	    out.printf("Discount: %.2f ", discountPrice*REDUCTION);
	    
	    double total = first + second + third - (discountPrice * REDUCTION);
	    
	    out.printf("\n total: %.2f ", total);
	 }
	
	public static void main(String[] args) {
		new Electronics().start();
	}

}
