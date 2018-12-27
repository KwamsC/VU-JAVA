package repeatCharacter1;
import java.util.Scanner;
import java.io.PrintStream;
public class RepeatCharacter1 {
	PrintStream out;
	RepeatCharacter1() {
			out = new PrintStream(System.out);
	}
	
	
	void print(int i){
		out.printf("!");
	}
	
	void print2(int j){
		out.printf(",");
	}
	
	void start(){
		Scanner in = new Scanner(System.in);
		int d=in.nextInt();
		for (int i=1; i<=d; i++){
			print(i);
		}
		
		int e=in.nextInt();
		for (int j=1; j<=e; j++){
			print2(j);
		}
	}
	
	public static void main(String[] args) {
			new RepeatCharacter1().start();
	}
}
