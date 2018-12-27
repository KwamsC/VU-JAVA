package bmi;
import java.io.PrintStream;
import java.util.Scanner;
import ui.UIAuxiliaryMethods;

public class BodyMassIndex {
	PrintStream out;
	public BodyMassIndex() {
		out = new PrintStream(System.out);
	}
	
	void start(){
		Scanner in = (UIAuxiliaryMethods.askUserForInput().getScanner());
		String person1= in.nextLine();
		String person2= in.nextLine();
		Scanner personScanner= new Scanner (person1);
		Scanner person2Scanner= new Scanner (person2);
		readPerson(personScanner);	
		readPerson(person2Scanner);
	
	}
	

	void readPerson(Scanner personScanner){
		personScanner.useDelimiter("\t");
		Person p= new Person();
		p.name=personScanner.next();
		p.sex=personScanner.next().charAt(0);
		p.length=personScanner.nextDouble();
		p.weight=personScanner.nextInt();
		print(p);
	}
	
	void print(Person p){
		double bmi = p.calculateBMI();
		if (p.sex == 'M'){
			out.printf("Mr %s BMI is %.1f and is %s \n", p.name, bmi, p.healthInRange());
		}else{
			out.printf("Mrs %s BMI is %.1f and is %s \n", p.name, bmi, p.healthInRange());
		}
	}

	public static void main(String[] args) {
		new BodyMassIndex().start();
	}

}
