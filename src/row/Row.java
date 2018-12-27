package row;

import java.io.PrintStream;
import java.util.Scanner;

import ui.UIAuxiliaryMethods;

public class Row {
	PrintStream out;
	
	public Row() {
		out = new PrintStream(System.out);
	}
	
	void start(){
		Scanner in = (UIAuxiliaryMethods.askUserForInput().getScanner());
		String row1 = in.nextLine();
		String row2 = in.nextLine();
		Scanner rowScanner= new Scanner(row1);
		Scanner row2Scanner= new Scanner(row2);
		RowClass r1=readFirstRow(rowScanner);
		printReverse(r1);
		out.printf("\n");
		RowClass r2=readSecondRow(row2Scanner);
		printReverse(r2);
		out.printf("\nLargest number of row 1: %d", r1.largestNumber());
		out.printf("\nLargest number of row 1: %d", r2.largestNumber());
		out.printf("\nthe largest number is in row %d.", r1.rowLargestNumber(r1.largestNumber(),r2.largestNumber()));
	}

	RowClass readFirstRow(Scanner rowScanner) {
		RowClass array1 = new RowClass();
		while(rowScanner.hasNext()){
			array1.add(rowScanner.nextInt());
		}		
		return array1;
	}
	
	RowClass readSecondRow(Scanner row2Scanner) {
		RowClass array2 = new RowClass();
		while(row2Scanner.hasNext()){
			array2.add(row2Scanner.nextInt());
		}
		return array2;
	}
	
	void printReverse(RowClass r1){
		for (int i=r1.numberOfElements-1; i>=0; i--){
			out.printf("%d ", r1.arrayRow[i]);
		}
	}
	
	public static void main(String[] args) {
		new Row().start();

	}

}
