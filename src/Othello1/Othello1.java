package Othello1;
import java.util.Scanner;
import java.io.PrintStream;
public class Othello1 {
	static final int NUMBER_SQUARES = 8*8;
	PrintStream out;
	Othello1(){
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
	    
	    out.printf("Enter the number of white pieces on the board: ");
	    int white = in.nextInt();
	    
	    out.printf("Enter the number of black pieces on the board: ");
	    int black = in.nextInt();
	    
	    double percentageBlackboard = (double) black
	    	    / (NUMBER_SQUARES) *100.0;
	    
	    double percentageBlack = (double) black
	    	    / (black + white) *100.0;
	    
	    out.printf("The percentage of black pieces on the board is: %.2f %% \n",
	    		percentageBlackboard);
	    
	    out.printf("The percentage of black pieces of all the pieces on the board is: %.2f %% \n",
	    		percentageBlack);
	    
	}
	
	public static void main(String[] args) {
		new Othello1().start();
	}
}
