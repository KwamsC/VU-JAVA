package pirate;

import java.io.PrintStream;
import java.util.Scanner;
import ui.UIAuxiliaryMethods;

public class Pirate {
	PrintStream out;
	static final String ROW_DELIMITER = "=",
						COORDINATE_DELIMITER ="[,]";
	public Pirate() {
		out = new PrintStream(System.out);
	}
	
	private void start() {
		Scanner in =  (UIAuxiliaryMethods.askUserForInput().getScanner());
		in.useDelimiter(ROW_DELIMITER);
		String startCoordinates = in.next();
		CoordinateRow startRow = readCoordinates(new Scanner(startCoordinates));
		while(in.hasNext()){
			String behindCoordinates= in.next();
			CoordinateRow BehindRow=readCoordinates(new Scanner(behindCoordinates));
			startRow.addBehind(BehindRow);
			
			if (in.hasNext()){
				String frontCoordinates= in.next();
				CoordinateRow FrontRow=readCoordinates(new Scanner(frontCoordinates));
				startRow.addFront(FrontRow);
			}
		}
		print(startRow);
	}
	
	CoordinateRow readCoordinates(Scanner coordinateScanner) {
		coordinateScanner.useDelimiter(",");
		CoordinateRow r1 =new CoordinateRow();
		while(coordinateScanner.hasNext()){
			Coordinate cor=new Coordinate();
			cor.x = coordinateScanner.nextInt()+cor.SHIFT;
			cor.y = coordinateScanner.nextInt();
			r1.add(cor);
		}
		return r1;	
	}
	
	void print(CoordinateRow startRow) {
		for (int i=0; i<startRow.numberOfElements; i++){
			out.printf("%d,%d\n", startRow.CorRow[i].x, startRow.CorRow[i].y);
		}
	}

	public static void main(String[] args) {
		new Pirate().start();
	}

}
