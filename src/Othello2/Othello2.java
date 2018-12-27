package Othello2;
import java.util.Scanner;
import java.io.PrintStream;
public class Othello2 {
	PrintStream out;
	static final int MILLI_TO_SEC = 1000;
	static final int MILLI_TO_MIN = 1000*60;
	static final int MILLI_TO_HOURS = 1000*60*60;
	static final int MAX_RUNTIME_PC = 1000;
	
	Othello2(){
		out = new PrintStream(System.out);
	}

	void start() {
		Scanner in = new Scanner(System.in);
		
		out.printf("Enter the time the black player thought: ");
		int timeBlack = in.nextInt();
		out.printf("Enter the time the white player thought: ");
		int timeWhite = in.nextInt();
		
		int milliseconde;
		
		if (timeBlack >= timeWhite && timeBlack >=MAX_RUNTIME_PC) {
			milliseconde = timeBlack;
		} else{
			milliseconde = timeWhite;	
		}
		
		int seconds =  (milliseconde / MILLI_TO_SEC) % 60 ;
		int minutes =  ((milliseconde / (MILLI_TO_MIN)) % 60);
		int hours   =  ((milliseconde / (MILLI_TO_HOURS)) % 24);
		
		if (timeBlack >= timeWhite){
			out.printf("The time the human player has spent thinking is: %02d:%02d:%02d", 
					hours, minutes, seconds);
		} else{
			out.printf("The time the human player has spent thinking is: %02d:%02d:%02d", 
					hours, minutes, seconds);
		}
		
	}	
	
	public static void main(String[] args) {
		new Othello2().start();
	}
}