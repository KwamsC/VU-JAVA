package NuclearPowerPlant;
import java.io.PrintStream;

class NuclearPowerPlant {
	PrintStream out;
	
	NuclearPowerPlant(){
		out = new PrintStream(System.out);
	}
	
	void print(int i){
		out.printf("NUCLEAR CORE UNSTABLE!!!\n"
				+ "Quarantine is in effect.\n"
				+ "Surrounding hamlets wil be evacuated. \n"
				+ "Anti Radiationsuits and iodine pills are mandatory. \n\n");
	}	
	
	void start(){
		for (int i=1; i<=3; i++){
			print(i);
		}
	}
	
	public static void main(String[] args) {
			new NuclearPowerPlant().start();
	}		
}
