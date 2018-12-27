package SecondSmallest;
import java.io.PrintStream;
import java.util.Scanner;
public class SecondSmallest {
	PrintStream out;
	SecondSmallest(){
		out = new PrintStream(System.out);
	}
	
	void start(){
		Scanner in = new Scanner(System.in);
		out.printf("number: ");
		int smallest=in.nextInt();
		int secondSmallest=in.nextInt();
		
		while(in.hasNext()){
			int number=in.nextInt();
			if (number>smallest && number<secondSmallest){
				secondSmallest=number;
			} else if(number<smallest){
				secondSmallest=smallest;
				smallest=number;
			}
		}
		out.printf("the second smallest number: %d ", secondSmallest);
	}
	
	public static void main(String[] args) {
		new SecondSmallest().start();
	}
}
