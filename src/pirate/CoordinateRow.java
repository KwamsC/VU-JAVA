package pirate;

public class CoordinateRow {
	Coordinate [] CorRow;
	int numberOfElements;
	static final int MAX_LENGTH=100;
	
	public CoordinateRow() {
		CorRow = new Coordinate [MAX_LENGTH];
		numberOfElements=0;
	}

	void add(Coordinate cor){
		CorRow[numberOfElements]= cor;
		numberOfElements++;
	}
	
	void addFront(CoordinateRow row){
		for (int i=numberOfElements-1; i>=0; i--){
			CorRow[i+row.numberOfElements]=CorRow[i];
		}
		for (int j=0; j<row.numberOfElements; j++){
			CorRow[j]=row.CorRow[j];
			numberOfElements++;
		}
	}
	
	void addBehind(CoordinateRow row){
			for (int i=0; i<row.numberOfElements; i++){
				CorRow[numberOfElements]=row.CorRow[i];
				numberOfElements++;
			}
	}
}
