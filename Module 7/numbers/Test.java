package numbers;

public class Test {
	double factor;
	int [] row =  new int[] {6,74,4};
	
	public Test() {
		factor=1.0;
	
	}

	void start(){
		factor++;
		System.out.println(row.length);
	}
	
	public static void main(String args[]) {
		new Test().start();
	}
}
