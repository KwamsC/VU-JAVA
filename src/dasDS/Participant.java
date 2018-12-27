package dasDS;

import java.io.Serializable;
import java.net.Socket;

public class Participant implements Serializable{
	private static final long serialVersionUID = 1L; 
	protected int x, y; // Position of the unit
	private int maxHitPoints; // Health
	protected int hitPoints;

	protected int attackPoints; // Attack points

	private int unitID; 	// Identifier of the unit
	protected Socket clientSocket; // The communication socket between this client and the board
	
	/* The thread that is used to make the unit run in a separate thread.
	 * We need to remember this thread to make sure that Java exits cleanly.
	 * (See stopRunnerThread())
	 */
	protected Thread runnerThread;

	public enum Direction {
		up, right, down, left
	};
	
	public enum UnitType {
		player, dragon, undefined,
	};

	
}
