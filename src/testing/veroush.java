package testing;

import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;
import ui.Event;
import ui.UIAuxiliaryMethods;

public class veroush {
	final static int WIDTH = 32, HEIGHT = 24;
	final static double FRAMES_PER_SECOND = 10.0;
	static final Coordinate START_COORDINATE_TAIL = new Coordinate(0, 0), START_COORDINATE_HEAD = new Coordinate(1, 0);
	static final String START_DIRECTION = "RIGHT";
	SnakeUserInterface ui;
	Coordinate appleCoordinate;
	String direction;
	CoordinateRow snake;
	Coordinate headSnake, newTail;

	veroush() {
		ui = UserInterfaceFactory.getSnakeUI(WIDTH, HEIGHT);
		snake = new CoordinateRow();
		appleCoordinate = new Coordinate();
		direction = "RIGHT";
	}

	private void ProcessAlarm(Event event) {
		moveSnake(snake);
		for(int j = 0; j < snake.numberOfCoordinates; j++){
			snake.coordinateArray[j]=preventWallCollision(snake.coordinateArray[j]);
		}
		showSnake(snake);
		while (checkCollision(appleCoordinate)) {
			growSnake(newTail);
			randomApple();
		}
	}

	void moveSnake(CoordinateRow snake) {
		ui.place(snake.coordinateArray[snake.numberOfCoordinates - 1].x,
				snake.coordinateArray[snake.numberOfCoordinates - 1].y, ui.EMPTY);
		if (direction == "RIGHT") {
			snake.moveRight(snake);
		}

		if (direction == "LEFT") {
			snake.moveLeft(snake);
		}

		if (direction == "UP") {
			snake.moveUp(snake);
		}

		if (direction == "DOWN") {
			snake.moveDown(snake);
		}
	}

	Coordinate preventWallCollision(Coordinate c){
		if(c.x >= WIDTH){
			c.x = 0;
		}if(c.x < 0){
			c.x = WIDTH - 1;
		}if(c.y >= HEIGHT){
			c.y = 0;
		}if(c.y < 0){
			c.y = HEIGHT - 1;
		}
		return c;
	}


	private void ProcessArrow(Event event) {

		if (event.data.equals("R") && !direction.equals("LEFT")) {
			direction = "RIGHT";
		}
		if (event.data.equals("L") && !direction.equals("RIGHT")) {
			direction = "LEFT";
		}
		if (event.data.equals("U") && !direction.equals("DOWN")) {
			direction = "UP";
		}
		if (event.data.equals("D") && !direction.equals("UP")) {
			direction = "DOWN";
		}
	}

	private void ProcessEvent(Event event) {
		if (event.name.equals("alarm")) {
			ProcessAlarm(event);
		} else if (event.name.equals("arrow")) {
			ProcessArrow(event);
		}
		ui.showChanges();
	}

	void growSnake(Coordinate cor) {
		newTail = new Coordinate();
		snake.addToMainRow(newTail);
	}

	void randomApple() {
		appleCoordinate.x = UIAuxiliaryMethods.getRandom(0, WIDTH - 1);
		appleCoordinate.y = UIAuxiliaryMethods.getRandom(0, HEIGHT - 1);
		ui.place(appleCoordinate.x, appleCoordinate.y, ui.FOOD);
		ui.showChanges();
	}

	void showSnake(CoordinateRow snake) {
		for (int i = 0; i < snake.numberOfCoordinates; i++) {
			ui.place(snake.coordinateArray[i].x, snake.coordinateArray[i].y, ui.SNAKE);
		}
		ui.showChanges();
	}

	boolean checkCollision(Coordinate cor) {
		for (int i = 1; i < snake.numberOfCoordinates; i++) {
			if (cor.x == snake.coordinateArray[i].x && cor.y == snake.coordinateArray[i].y) {
				return true;
			}
		}
		return false;
	}

	private void start() {
		ui.setFramesPerSecond(FRAMES_PER_SECOND);
		snake.addToMainRow(START_COORDINATE_HEAD);
		snake.addToMainRow(START_COORDINATE_TAIL);
		headSnake = snake.coordinateArray[0];
		ui.showChanges();
		randomApple();
		while (!checkCollision(headSnake)) {
			Event event = ui.getEvent();
			ProcessEvent(event);
			headSnake = snake.coordinateArray[0];
		}
		ui.printf("GAME OVER");
	}

	public static void main(String[] args) {
		new veroush().start();
	}
}