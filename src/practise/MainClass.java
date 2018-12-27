package practise;
import java.io.PrintStream;
public class MainClass {
	static PrintStream out;
	
	public MainClass() {
		out = new PrintStream(System.out);
	}

	
	void start(){	
		out.printf("%d",(7/3));
	}
	
	public static void main(String[] args) {
	           new MainClass().start();
	}
	
}

