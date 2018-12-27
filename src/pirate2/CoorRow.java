package pirate2;

public class CoorRow {
	Coor[] CorRow;
	int numberOfCors;
	static final int MAX_LENGTH=100;
	
	CoorRow(){
		CorRow=new Coor[MAX_LENGTH];
		numberOfCors=0;
	}
	
	void addCor(Coor cor){
		CorRow[numberOfCors]= cor;
		numberOfCors++;
	}
	
	void addFront(CoorRow row){
		for (int i=numberOfCors-1; i>=0; i--){
			CorRow[i+row.numberOfCors]=CorRow[i];
		}
		for (int j=0; j<row.numberOfCors; j++){
			CorRow[j]=row.CorRow[j];
			numberOfCors++;
		}
	}
	
	void addBehind(CoorRow row){
		for (int i=0; i<row.numberOfCors; i++){
			CorRow[numberOfCors]=row.CorRow[i];
			numberOfCors++;
		}
}
	

}
