package dasDS;

public class CorRow {
	static final int MAX_NR_OF_COORDINATES = 25*25;
	int numberOfCoordinates;
	Unit[] coordinateArray;

	CorRow() {
		coordinateArray = new Unit[MAX_NR_OF_COORDINATES];
		numberOfCoordinates = 0;
	}

}
