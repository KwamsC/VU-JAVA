package testing;

public class CoordinateRow {
	static final int MAX_NR_OF_COORDINATES = 100;
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

	void moveRight(CoordinateRow snake) {
		for (int i = snake.numberOfCoordinates-1; i>0;i--) {
			snake.coordinateArray[i].x = snake.coordinateArray[i-1].x;
			snake.coordinateArray[i].y = snake.coordinateArray[i-1].y;
		}
		snake.coordinateArray[0].x +=1;
	}

	void moveLeft(CoordinateRow snake) {
		for (int i = snake.numberOfCoordinates-1; i>0;i--) {
			snake.coordinateArray[i].x = snake.coordinateArray[i-1].x;
			snake.coordinateArray[i].y = snake.coordinateArray[i-1].y;
		}
		snake.coordinateArray[0].x -=1;
	}

	void moveUp(CoordinateRow snake) {
		for (int i = snake.numberOfCoordinates -1;i > 0; i--) {
			snake.coordinateArray[i].x = snake.coordinateArray[i-1].x;
			snake.coordinateArray[i].y = snake.coordinateArray[i-1].y;
		}
		snake.coordinateArray[0].y -=1;
	}

	void moveDown(CoordinateRow snake) {
		for (int i = snake.numberOfCoordinates -1;i > 0; i--) {
			snake.coordinateArray[i].x = snake.coordinateArray[i-1].x;
			snake.coordinateArray[i].y = snake.coordinateArray[i-1].y;
		}
		snake.coordinateArray[0].y+=1;
	}
}