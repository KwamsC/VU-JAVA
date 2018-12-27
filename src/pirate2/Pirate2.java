package pirate2;

import java.util.Scanner;
import java.io.PrintStream;
import ui.UIAuxiliaryMethods;

public class Pirate2 {
	PrintStream out;
	
	Pirate2(){
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = (UIAuxiliaryMethods.askUserForInput().getScanner());
		in.useDelimiter("=");
		String startCors=in.next();
		Scanner scanStart= new Scanner(startCors);
		readStart(scanStart);
	}

	private void readStart(Scanner scanStart) {
		CoorRow r1= new CoorRow();
		while (scanStart.hasNext()){
			String starCoordinates= scanStart.next();
			Scanner coordinatenSetScanner= new Scanner(starCoordinates);
			Coor c=readCors(coordinatenSetScanner);
			r1.addCor(c);
		}
		print(r1);
	}

	private Coor readCors(Scanner coordinatenSetScanner) {
		Coor cor= new Coor();
		coordinatenSetScanner.useDelimiter(",");
		cor.x=coordinatenSetScanner.nextInt()+1;
		cor.y=coordinatenSetScanner.nextInt();
		return cor;
	}
	
	void print(CoorRow r1) {
		for (int i=0; i<r1.numberOfCors; i++){
			out.printf("%d,%d ", r1.CorRow[i].x, r1.CorRow[i].y);
		}
	}

	public static void main(String[] args) {
		new Pirate2().start();
	}
}
