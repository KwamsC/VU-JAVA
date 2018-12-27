package numbers;
import java.io.PrintStream;
public class Reverse {
	PrintStream out;

	public Reverse() {
		out= new PrintStream(System.out);
	}
	
	void printNumbers(int n){
		if (n<10){
			out.printf("%d",n);
			return;
		}
		
		out.printf("%d",n%10);
		printNumbers(n/10); 
	}
	
	void start(){
		printNumbers(1234567800); 
	}

	public static void main(String[] args) {
		new Reverse().start();
	}

}
