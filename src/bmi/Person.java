package bmi;

public class Person {
	String name;
	char sex;
	int weight;
	double length, bmi;
	static final double	BMI_MIN_BORDER= 18.5,
			BMI_MAX_BORDER= 25;

	public Person() {
	}

	double calculateBMI(){
		bmi=0;
		return bmi=weight/(length*length);			
	}
	
	String healthInRange(){
		if (bmi>BMI_MIN_BORDER && bmi<BMI_MAX_BORDER){
			return "healthy";
		} else {
			return "unhealthy";
		}
				
	}
	
}
