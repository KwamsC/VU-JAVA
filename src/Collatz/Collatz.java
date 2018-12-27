package Collatz;
import java.util.Scanner;
import java.io.PrintStream;
public class Collatz {
	PrintStream out;
	Collatz(){
		out = new PrintStream(System.out);
	}
	void start(){
		Scanner in = new Scanner(System.in);
		out.printf("Enter number: ");
			int number=in.nextInt();
		
		
		while(number>1){
			if(number % 2 == 0){
				number=number/2;
			} else {
				number=(3*number)+1;
			}
			
			out.printf("%d ", number);
		}
			
		
	 }
	
	
	public static void main(String[] args) {
		new Collatz().start();
	}

}
