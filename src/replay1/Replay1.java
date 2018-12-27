package replay1;

import ui.OthelloReplayUserInterface;
import ui.UserInterfaceFactory;
import java.util.Scanner;
import ui.UIAuxiliaryMethods;

public class Replay1 {
	OthelloReplayUserInterface ui;
	static final int WHITE_X = 3;
	static final int WHITE_Y = 3;
	static final int WHITE2_X = 4;
	static final int WHITE2_Y = 4;
	static final int BLACK_X = 3;
	static final int BLACK_Y = 4;
	static final int BLACK2_X = 4;
	static final int BLACK2_Y = 3;
	static final int MAX = 7;

	public Replay1() {
		UserInterfaceFactory.enableLowResolution(true);
		ui = UserInterfaceFactory.getOthelloReplayUI();
	}

	void start() {
		initialize();
		Scanner in = (UIAuxiliaryMethods.askUserForInput().getScanner());

		while (in.hasNextLine()) {
			String lineData = in.nextLine();
			Scanner lineScanner = new Scanner(lineData);
			readdata(lineScanner);
			ui.wait(1000);
		}

		ui.showChanges();
		ui.clearStatusBar();
	}

	void initialize() {
		ui.place(WHITE_X, WHITE_Y, ui.WHITE);
		ui.place(WHITE2_X, WHITE2_Y, ui.WHITE);
		ui.place(BLACK_X, BLACK_Y, ui.BLACK);
		ui.place(BLACK2_X, BLACK2_Y, ui.BLACK);
	}

	void readdata(Scanner lineData) {
		int color = getColor(lineData.next());
		int waitTime = lineData.nextInt();
		String makeMove = lineData.next();

		if (makeMove.equals("move")) {
			makeMove(lineData, color);
		} else {
			ui.printf("%s passed\n", getColor(color));
		}

		ui.wait(waitTime);
		ui.showChanges();
	}

	String getColor(int color) {
		if (color == ui.WHITE) {
			return "white";
		} else {
			return "black";
		}
	}

	int getColor(String color) {
		if (color.equals("white")) {
			return ui.WHITE;
		} else {
			return ui.BLACK;
		}
	}

	void makeMove(Scanner data, int color) {
		int placed = 0;
		while (data.hasNext()) {
			int x = checkInRange(data.next().charAt(0) - 'a', 0, MAX);
			int y = checkInRange(data.nextInt() - 1, 0, MAX);
			ui.place(x, y, color);
			placed++;
		}
		ui.printf("%s : conquered %d\n", getColor(color), placed);
	}

	int checkInRange(int input, int start, int end) {
		int result = input;
		if (result < start || result > end) {
			ui.printf("%d\n", result);
			ui.printf("out of bounds");
			System.exit(1);
		}
		return result;
	}

	public static void main(String[] args) {
		new Replay1().start();
	}
}