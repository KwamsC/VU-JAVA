package Pyramid;
import java.io.PrintStream;

public class Pyramid {
	
	static PrintStream out;
	Pyramid() {
		out = new PrintStream(System.out);
	}
	
	void start(){
		int counter = 0; 
		for(int i=0;i<14;i++) {
	         for(int j=0;j<40-i;j++) {
	            out.printf(" ");
	         }
	        for(int j=0; j<=i+counter;j++) {
	        	char c='a';
	            out.printf("%c",c+i);
	        }
	        counter++;
	      out.printf("\n");  
	    }
	}

	public static void main(String[] args) {
		new Pyramid().start();
	}
}
