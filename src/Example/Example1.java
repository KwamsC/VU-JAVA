package Example;
import java.util.Scanner;
import java.io.PrintStream;
public class Example1 {
	static final int	STARTING_YEAR = 1950,
						FINAL_YEAR = 2050;
	PrintStream out;
	

	public Example1() {
		out = new PrintStream(System.out);
	}
	
	void printPercentageOfCases(double percentage){
		out.printf("the percentage of ilnesses: %.2f\n ", percentage);
	}
	
	int readInRange(Scanner input, int start, int end){
		int result = input.nextInt();
		if (result < start || result > end){
			out.printf("Error: d% is not in range (%d, %d)\n", result, start, end);
		}
		System.exit(1);
		return result;
	}
	
	boolean oddMonth(Scanner input){
		readInRange(input, 1,31);
		int month = readInRange(input, 1,12);
		readInRange(input, STARTING_YEAR, FINAL_YEAR);
		
		return month %2!=0;
	}
	
	public void start(){
		Scanner in = new Scanner(System.in);
		int totalSeizures=0,
		numberInOddMonths=0;
		
		while (in.hasNext()){
			String date = in.nextLine();
			Scanner dateScanner = new Scanner(date);
			
			if (oddMonth(dateScanner)){
				numberInOddMonths+=1;
			}
			totalSeizures=+1;
		}
		
		double percentage= ((double) numberInOddMonths/totalSeizures) *100.0;
		printPercentageOfCases(percentage);
	}
	

	
	

	public static void main(String[] args) {
		new Example1().start();
	}

}
