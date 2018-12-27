package test1;

public class CalculateX {

	double x;
	int numberOfTops;
	double result;
	String team;
	CalculateX(){
		team="voetbalzeebuRgia";
	}

	private void start() {
//		System.out.println(team.substring(team.length()-4));
		if(team.substring(team.length()-4).equals("rgia")){
			System.out.println(team.substring(team.length()-4));
		}
		
		
	}
	

	public static void main(String args[]){
		new CalculateX().start();
	}
}
