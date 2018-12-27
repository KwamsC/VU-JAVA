package matrix;
import java.lang.Math;
import java.io.PrintStream;

public class Matrix {
	PrintStream out;
    int[][] input = {
            {-2, 5, 8, 2},
            {9, -6, 5, 8},
            {1, -8, -9, -3},
            {-1, 9, -5, 2}
        };
    
	public Matrix() {
		out = new PrintStream(System.out);
	}
	
	void start(){
		int rows=input.length;
    	int columns=input[0].length;
    	int maxSumD=0;
    	int [] diagonal = new int[rows+columns-1];//There can be at most  n + n -1 diagonals to be printed
		int [] tempMax = new int[rows+1];
		int counter=0;
		
		for(int r=0; r<rows; r++){		//top half
			int max=0;
			tempMax[0] = 0;
			for (int c=0; c<=r; c++){
				int i=r-c;
				tempMax [c+1]=Math.max(0, tempMax[c]+input[i][c]);
				max=Math.max(max,tempMax[c+1]);
			}
			diagonal[counter]=max;
			counter++;
		}
		
		for(int r=rows-1; r>0; r--){	//lower half
			int max=0;
			int counter2=0;
			tempMax[0] = 0;
			for (int c=columns-1, j=0; r<=c; c--, j++){
				int i=r+j;
				tempMax[counter2+1]=Math.max(0, tempMax[counter2]+input[i][c]);
				max=Math.max(max,tempMax[counter2+1]);
				counter2++;
			}
			diagonal[counter]=max;
			counter++;
		}
	
		for (int i = 0; i < diagonal.length; i++) {
			if (maxSumD < diagonal[i]) {
				maxSumD = diagonal[i];
			}
		}
		out.printf("%d", maxSumD);
	}

	public static void main(String[] args) {
		new Matrix().start();
	}
}