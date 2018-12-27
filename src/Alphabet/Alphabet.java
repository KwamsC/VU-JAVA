package Alphabet;
import java.util.Scanner;
import java.io.PrintStream;
public class Alphabet {
	PrintStream out;
	Alphabet(){
		out = new PrintStream(System.out);	
	}
	
	void start(){
		Scanner in = new Scanner(System.in);
		for (char c=98; c<='z';c++){
			out.printf("%c, ",c);
		}
	}

	public static void main(String[] args) {
		new Alphabet().start();

	}

}
