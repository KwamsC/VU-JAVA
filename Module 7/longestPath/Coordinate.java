package longestPath;

public class Coordinate {
	int x,
	y;

	public Coordinate() {
	}

	Coordinate(int x, int y) {
		this.x=x;
		this.y=y;			
	}

	boolean isMatch(Coordinate cor){
		if (cor.x==x && cor.y==y){
			return true;
		}
		return false;
	}
}
