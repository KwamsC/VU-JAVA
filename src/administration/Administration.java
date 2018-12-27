package administration;
import java.io.PrintStream;
import java.util.Scanner;
import ui.UIAuxiliaryMethods;

public class Administration {
	static final double PASS_GRADE= 5.5;
	static final int BORDER_GRADE= 6;
	static final int MATCH_BENCHMARK= 20;
	static final String C ="_";
	PrintStream out;
	public Administration() {
		out = new PrintStream(System.out);
	}
		
	void readgrades(Scanner gradeScanner) {
		gradeScanner.useDelimiter(C);
		String studentName=gradeScanner.next();
		String grades = gradeScanner.next();
		
		Scanner gradeAverage = new Scanner(grades);
		double roundedGrade = operateGrades(gradeAverage);
		printStudentAverage(roundedGrade, studentName);
	}
	
	double operateGrades(Scanner gradeAverage) {
		double sum=0, count=0, average=0, roundedGrade=0;
		while (gradeAverage.hasNext()){
			sum+= gradeAverage.nextInt();
			count++;
		}
		average=sum/count;
		roundedGrade = roundGradeToHalf(average);
		return roundedGrade;
	}
	
	void printStudentAverage(double roundedGrade, String studentName){
		if (roundedGrade >=PASS_GRADE && roundedGrade <BORDER_GRADE){
			out.printf("%s has an average of 6- \n", studentName);
		}else {
			out.printf("%s has an average of %.1f \n", studentName, roundedGrade);
		}
	}
	
	double roundGradeToHalf(double average){
		return ((int)(average*2+0.5)) / 2.0;
	}
	
	void checksimilarity(Scanner similarityScanner) {
		similarityScanner.useDelimiter(";");
		String similarityScores=similarityScanner.next();
		Scanner similarityTest=new Scanner(similarityScores);
		scoreScanner(similarityTest);
		
		if (similarityScanner.hasNext()){
			String matchingStudents=similarityScanner.next();
			Scanner matchingStudentScanner=new Scanner(matchingStudents);
			matchNameScanner(matchingStudentScanner);
		}else{
			out.printf("\tno matches found\n");
		}	
	}
	
	void matchNameScanner(Scanner matchingStudentScanner) {
		matchingStudentScanner.useDelimiter(",");
		while (matchingStudentScanner.hasNext()){
			out.printf("\t%s\n",matchingStudentScanner.next());
		}
	}

	void scoreScanner(Scanner similarityTest) {
		similarityTest.useDelimiter("=");
		out.printf("\t");
		while (similarityTest.hasNext()){
			int sim = similarityTest.nextInt();
			if (sim<MATCH_BENCHMARK && sim >0){
				out.printf("-");
			}else if(sim>=MATCH_BENCHMARK) {
				out.printf("^");
			}else{
				out.printf("_");
			}
		}
		out.printf("\n");
	}

	void start(){
		Scanner in = (UIAuxiliaryMethods.askUserForInput().getScanner());
		while (in.hasNext()){
			String studentGrades=in.nextLine();
			String similarityCheck=in.nextLine();
			
			Scanner gradeScanner=new Scanner(studentGrades);
			Scanner similarityScanner=new Scanner(similarityCheck);
			
			readgrades(gradeScanner);
			checksimilarity(similarityScanner);
		}
	}

	public static void main(String[] args) {
		new Administration().start();
	}
}

