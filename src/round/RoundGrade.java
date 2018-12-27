package round;

public class RoundGrade {
	static final double GRADE1 = 6.3;
	static final double GRADE2 = 6.2;
	
	
	
	public static void main(String[] args) {
		new RoundGrade().start();
	}

	private void start() {
	int number = (int)(GRADE1);
	//System.out.print(number);
	double newNumber = GRADE1-number;
	double adding;
	
	if (newNumber<0.25){
		 adding=0;	
	} else {
		 adding=0.5;
	}
		System.out.print(number+adding);
	}
}
