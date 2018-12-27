package numbers;
import java.io.PrintStream;

public class Numbers {
	PrintStream out;

	
	public Numbers() {
		out = new PrintStream(System.out);
	}
	
	void printNumbers(int n){
		out.printf("%d ",n);
		if(n==1){
			return;	
		}
		printNumbers(n-1);
		out.printf("%d ",n);
	}
	
	
	void start(){
		printNumbers(3); 
	}

	public static void main(String[] args) {
		new Numbers().start();

	}

}
