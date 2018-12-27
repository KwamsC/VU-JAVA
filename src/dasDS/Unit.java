package dasDS;

import java.io.Serializable;

public abstract class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	public int	x, y;

	// Health
	private int maxHitPoints;
	protected int hitPoints;

	// Attack points
	protected int attackPoints;

	// Identifier of the unit
	private int unitID;
	
	protected Thread runnerThread;

	public Unit() {
	}
	
	public enum UnitType {
		player, dragon, undefined,
	};

	public Unit(int x, int y) {
		this.x=x;
		this.y=y;
	}

	boolean isMatch(Unit cor){
		if (cor.x==x && cor.y==y){
			return true;
		}
		return false;
	}
}
