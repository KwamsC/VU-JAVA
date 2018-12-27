package row;

public class RowClass {
	static final int 	MAX_LENGTH=20,
						MIN_LENGTH=1;
	int [] arrayRow;
	int numberOfElements;
	int largestNumber;
	
	
	public RowClass() {
		arrayRow= new int[MAX_LENGTH];
		numberOfElements=0;
	}
	
	void add(int i){
		arrayRow[numberOfElements]= i;
		numberOfElements++;
	}
	
	int largestNumber(){
		int result = Integer.MIN_VALUE;
		for (int i=0; i<numberOfElements; i++){
				if (arrayRow[i]> result){
				result=arrayRow[i];
			}
		}
		return result;
	}
		
	int rowLargestNumber(int row1, int row2){
		if (row1<row2){
			return 2;
		} else {
			return 1;
		}	
	}

}
