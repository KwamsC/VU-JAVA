package longestPath;
import java.util.Scanner;
import ui.LabyrinthUserInterface;
import ui.UIAuxiliaryMethods;
import ui.UserInterfaceFactory;

public class LongestPath {
	LabyrinthUserInterface ui;
	final static int	WEST=1, SOUTH=2, EAST=3, NORTH=4;
	final static int 	WIDTH=32,	HEIGHT=24;
	final static int 	WAIT_TIME=5;
	static final String COORDINATE_DELIMITER = "=";
	Coordinate end;
	CoordinateRow path;
	CoordinateRow wall;
	CoordinateRow longestPath;

	public LongestPath() {
		ui = UserInterfaceFactory.getLabyrinthUI(WIDTH, HEIGHT);
		path = new CoordinateRow();
		wall = new CoordinateRow();
		end = new Coordinate();
		longestPath = new CoordinateRow();
	}

	void start(){
		initiallize();
		findLongestPath();
		placeLongesPath();
	}

	private void initiallize() {
		Scanner in = (UIAuxiliaryMethods.askUserForInput().getScanner());
		in.useDelimiter(COORDINATE_DELIMITER);
		String start = in.next();
		Scanner startScanner = new Scanner(start);
		readStart(startScanner);
		String endCoordinate = in.next();
		Scanner endScanner = new Scanner(endCoordinate);
		readEnd(endScanner);
		String wallCoordinates=in.next();
		Scanner wallScanner = new Scanner(wallCoordinates);
		readwalls(wallScanner);
		ui.showChanges();
	}

	private void readStart(Scanner startPoint) {
		Coordinate first = new Coordinate();
		first.x= startPoint.nextInt();
		first.y= startPoint.nextInt();
		path.add(first);
		ui.place(first.x, first.y, LabyrinthUserInterface.PATH);
	}

	private void readEnd(Scanner endScanner) {
		end.x= endScanner.nextInt();
		end.y= endScanner.nextInt();
		ui.encircle(end.x, end.y);
	}

	private void readwalls(Scanner wallScanner) {
		while(wallScanner.hasNext()){
			Coordinate w1= new Coordinate();
			w1.x=wallScanner.nextInt();
			w1.y=wallScanner.nextInt();
			wall.add(w1);
			ui.place(w1.x, w1.y, LabyrinthUserInterface.WALL);
		}	
	}

	private void findLongestPath() {
		if (path.CorRow[path.numberOfElements-1].isMatch(end)){
			compareLongestPath();
		}
		for (int direction=WEST; direction<=NORTH; direction++){
			Coordinate head=path.CorRow[path.numberOfElements-1];
			Coordinate newHead=new Coordinate();
			movePath(newHead, head, direction);
			if (!checkCollision(newHead)){
				path.add(newHead);
				ui.place(newHead.x, newHead.y, LabyrinthUserInterface.PATH);
				ui.showChanges();
				ui.wait(WAIT_TIME);
				findLongestPath();
			}
		}
		removeChanges();
	}

	private void compareLongestPath(){
		if (longestPath.numberOfElements<path.numberOfElements){
			longestPath= new CoordinateRow();
			for (int i=0; i<=path.numberOfElements-1;i++){
				longestPath.add(path.CorRow[i]);
			}
		}	
	}
	private void movePath(Coordinate newHead, Coordinate head, int direction) {
		if (direction==WEST){
			newHead.x=head.x-1;
			newHead.y=head.y;
		}

		if (direction==SOUTH){
			newHead.y=head.y+1;
			newHead.x=head.x;
		}

		if (direction==EAST){
			newHead.x=head.x+1;
			newHead.y=head.y;
		}

		if (direction==NORTH){
			newHead.y=head.y-1;
			newHead.x=head.x;
		}
	}

	boolean checkCollision(Coordinate cor){
		for (int i=0; i<wall.numberOfElements; i++){
			if(cor.x==wall.CorRow[i].x && cor.y==wall.CorRow[i].y){
				return true;
			}
		}

		for (int i=0; i<path.numberOfElements; i++){
			if(cor.x==path.CorRow[i].x && cor.y==path.CorRow[i].y){
				return true;
			}
		}
		return false;
	}

	void removeChanges(){
		ui.place(path.CorRow[path.numberOfElements-1].x, path.CorRow[path.numberOfElements-1].y, LabyrinthUserInterface.EMPTY);
		path.numberOfElements--;
		ui.wait(WAIT_TIME);
		ui.showChanges();
	}

	private void placeLongesPath(){
		for (int j=0; j<=longestPath.numberOfElements-1;j++){
			ui.place(longestPath.CorRow[j].x, longestPath.CorRow[j].y, LabyrinthUserInterface.PATH);			
		}
		ui.printf("The longest path is %d", longestPath.numberOfElements);
		ui.showChanges();
	}

	public static void main(String[] args) {
		new LongestPath().start();
	}
}
