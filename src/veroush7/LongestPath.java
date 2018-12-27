package veroush7;

import java.util.Scanner;
import ui.LabyrinthUserInterface;
import ui.UIAuxiliaryMethods;
import ui.UserInterfaceFactory;

public class LongestPath {
	final static int WIDTH = 32, HEIGHT = 24;
	final static int WAIT = 100;
	final static int WEST = 1, SOUTH = 2, EAST = 3, NORTH = 4;
	LabyrinthUserInterface ui;
	Coordinate end;
	Coordinate beginning;
	CoordinateRow walls;
	CoordinateRow path;
	Coordinate testPath;
	CoordinateRow longestPath;

	LongestPath() {
		ui = UserInterfaceFactory.getLabyrinthUI(WIDTH, HEIGHT);
		end = new Coordinate();
		beginning = new Coordinate();
		walls = new CoordinateRow();
		path = new CoordinateRow();
		longestPath = new CoordinateRow();
	}

	void start() {
		Scanner in = (UIAuxiliaryMethods.askUserForInput().getScanner());
		String elements = in.nextLine();
		Scanner elementScanner = new Scanner(elements);
		placeElements(elementScanner);
		wallScanner(in);
		ui.showChanges();
		searchLongestPath();
		showLongestPath();
	}

	private void showLongestPath() {
		for (int j=0; j<=longestPath.numberOfCoordinates-1;j++){
			ui.place(longestPath.coordinateArray[j].x, longestPath.coordinateArray[j].y, LabyrinthUserInterface.PATH);			
		}
		ui.printf("The longest path is %d", longestPath.numberOfCoordinates);
		ui.showChanges();
	}

	private void placeElements(Scanner elementScanner) {
		elementScanner.useDelimiter("=");
		String begin = elementScanner.next();
		String end = elementScanner.next();
		String beginWall = elementScanner.next();
		Scanner beginScanner = new Scanner(begin);
		Scanner endScanner = new Scanner(end);
		Scanner beginWallScanner = new Scanner(beginWall);
		placeBegin(beginScanner);
		placeEnd(endScanner);
		placeWall(beginWallScanner);
	}

	private void wallScanner(Scanner in) {
		while (in.hasNext()) {
			Coordinate w = new Coordinate();
			w.x = in.nextInt();
			w.y = in.nextInt();
			walls.addToMainRow(w);
			ui.place(w.x, w.y, LabyrinthUserInterface.WALL);
		}
	}

	private void placeWall(Scanner beginWallScanner) {
		Coordinate beginWall = new Coordinate();
		beginWall.x = beginWallScanner.nextInt();
		beginWall.y = beginWallScanner.nextInt();
		ui.place(beginWall.x, beginWall.y, ui.WALL);
		walls.addToMainRow(beginWall);
	}

	private void placeEnd(Scanner endScanner) {
		end.x = endScanner.nextInt();
		end.y = endScanner.nextInt();
		ui.encircle(end.x, end.y);
	}

	private void placeBegin(Scanner beginScanner) {
		beginning.x = beginScanner.nextInt();
		beginning.y = beginScanner.nextInt();
		ui.place(beginning.x, beginning.y, ui.PATH);
		path.addToMainRow(beginning);
	}

	private void searchLongestPath() {
		if (path.coordinateArray[path.numberOfCoordinates-1].isMatch(end)){
			checkLongestPath();
		}
		for (int direction = WEST; direction <= NORTH; direction++) {
			testPath = new Coordinate();
			checkPath(direction, testPath);
			if (!checkCollision(testPath)) {
				path.addToMainRow(testPath);
				showPath(path);
				ui.wait(WAIT);
				searchLongestPath();
			}
		}ui.place(path.coordinateArray[path.numberOfCoordinates-1].x, path.coordinateArray[path.numberOfCoordinates-1].y, ui.EMPTY);
		path.numberOfCoordinates--;
		ui.wait(WAIT);
	}

	void checkPath(int direction, Coordinate testPath) {
		if (direction == EAST) {
			path.moveLeft(path, testPath);
		}
		if (direction == WEST) {
			path.moveRight(path, testPath);
		}
		if (direction == NORTH) {
			path.moveUp(path, testPath);
		}
		if (direction == SOUTH) {
			path.moveDown(path, testPath);
		}
	}

	void showPath(CoordinateRow path) {
		for (int i = 0; i < path.numberOfCoordinates; i++) {
			ui.place(path.coordinateArray[i].x, path.coordinateArray[i].y, ui.PATH);
		}
		ui.showChanges();
	}

	private void checkLongestPath() {
		if (longestPath.numberOfCoordinates<path.numberOfCoordinates){
			longestPath= new CoordinateRow();
			for (int i=0; i<=path.numberOfCoordinates-1;i++){
				longestPath.addToMainRow(path.coordinateArray[i]);
			}
		}	
	}

	boolean checkCollision(Coordinate c) {
		for (int i = 1; i < walls.numberOfCoordinates; i++) {
			if (c.x == walls.coordinateArray[i].x && c.y == walls.coordinateArray[i].y) {
				return true;
			}
		}

		for (int i = 0; i < path.numberOfCoordinates; i++) {
			if (c.x == path.coordinateArray[i].x && c.y == path.coordinateArray[i].y) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		new LongestPath().start();
	}
}
