package array;
import java.io.PrintStream;
import java.util.Scanner;

public class Array {
	static final int ARRAY_LENGTH= 20;
	PrintStream out;
	int [] arrayRow;
	int arrayNUmber;
	

	public Array() {
		arrayRow=new int[ARRAY_LENGTH];
		arrayNUmber=0;
		out = new PrintStream(System.out);
	}
	
	void start(){
		Scanner in = new Scanner(System.in);
		for (int i=0; i < ARRAY_LENGTH; i++){
			arrayRow[arrayNUmber]=in.nextInt();
			arrayNUmber++;			
		}
		printReverse();
	}
	
	private void printReverse() {
		for (int i=ARRAY_LENGTH-1; i>0; i--){
			out.printf("%d ", arrayRow[i]);	
		}
		
	}

	public static void main(String[] args) {
		new Array().start();
	}
	
	

}
