package veroush7;

public class CoordinateRow {
	static final int MAX_NR_OF_COORDINATES = 768;
	int numberOfCoordinates;
	Coordinate[] coordinateArray;

	CoordinateRow() {
		coordinateArray = new Coordinate[MAX_NR_OF_COORDINATES];
		numberOfCoordinates = 0;
	}

	void addToMainRow(Coordinate coordinate) {
		coordinateArray[numberOfCoordinates] = coordinate;
		numberOfCoordinates = numberOfCoordinates + 1;
	}

	void moveRight(CoordinateRow path, Coordinate testPath) {
		testPath.x=path.coordinateArray[numberOfCoordinates-1].x+1;
		testPath.y=path.coordinateArray[numberOfCoordinates-1].y;
	}

	void moveLeft(CoordinateRow path,Coordinate testPath) {
		testPath.x=path.coordinateArray[numberOfCoordinates-1].x-1;
		testPath.y=path.coordinateArray[numberOfCoordinates-1].y;
	}

	void moveUp(CoordinateRow path, Coordinate testPath) {
		testPath.x=path.coordinateArray[numberOfCoordinates-1].x;
		testPath.y=path.coordinateArray[numberOfCoordinates-1].y-1;
	}

	void moveDown(CoordinateRow path, Coordinate testPath) {
		testPath.x=path.coordinateArray[numberOfCoordinates-1].x;
		testPath.y=path.coordinateArray[numberOfCoordinates-1].y+1;
	}
}