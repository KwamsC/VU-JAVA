package snake;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;
import ui.Event;
import ui.UIAuxiliaryMethods;

public class playSnake {
	final static int 	WIDTH=32,	HEIGHT=24;	
	final static double FRAMES_PER_SECOND = 10.0;
	final static int 	CORRECTION_SHIFT=1;
	SnakeUserInterface ui;
	Coordinate apple;
	String direction;	
	CoordinateRow snake;
	boolean hasChange;
	
	public playSnake() {
		ui = UserInterfaceFactory.getSnakeUI(WIDTH, HEIGHT);
		ui.setFramesPerSecond(FRAMES_PER_SECOND);
		snake = new CoordinateRow();	
		apple = new Coordinate();
		direction="R";
	}
	
	void start(){
		initializeSnake();
		Coordinate top=snake.CorRow[0];
		while(!snake.checkCollision(top)){
			Event event = ui.getEvent();
			ProcessEvent(event);
			ui.showChanges();
			top=snake.CorRow[0];
		}
		ui.printf("GAME OVER");
	}
	
	void initializeSnake(){
		Coordinate firstTail=new Coordinate(0,0);
		Coordinate firstHead=new Coordinate(1,0);
		ui.place(firstTail.x, firstTail.y, ui.SNAKE);
		ui.place(firstHead.x, firstHead.y, ui.SNAKE);
		snake.add(firstTail);
		snake.addF(firstHead);
		randomizeApple();
		ui.showChanges();
	}
	
	private void ProcessEvent(Event event) {
		if (event.name.equals("alarm")){
			ProcessAlarm(event);
		} else if(event.name.equals("arrow")){
			ProcessArrow(event);
		}
		ui.showChanges();
	}
	
	private void ProcessAlarm(Event event){
		Coordinate head=snake.CorRow[0];
		Coordinate tail=snake.CorRow[snake.numberOfElements-1];		
		Coordinate newHead=new Coordinate();
		snake.addF(newHead);
		moveSnake(newHead, head);
		ReEmerge(newHead);
		ui.place(newHead.x, newHead.y, ui.SNAKE);
		
		if (!growSnake(newHead)){	
			snake.numberOfElements--;
			ui.place(tail.x, tail.y, ui.EMPTY);
		}
		hasChange=false;
	}
	
	private void ProcessArrow(Event event) {
		if (!hasChange){
			hasChange=true;
			if(event.data.equals("R") && !direction.equals("L")){
				direction = event.data;
			}
			if(event.data.equals("L") && !direction.equals("R")){
				direction = event.data;
			}
			if(event.data.equals("U") && !direction.equals("D")){
				direction = event.data;
			}
			if(event.data.equals("D") && !direction.equals("")){
				direction = event.data;
			}
		}	
	}
	
	private void moveSnake(Coordinate newHead, Coordinate head) {
		if (direction.equals("R")){
			newHead.x=head.x+CORRECTION_SHIFT;
			newHead.y=head.y;
		}
		
		if (direction.equals("L")){
			newHead.x=head.x-CORRECTION_SHIFT;
			newHead.y=head.y;
		}
		
		if (direction.equals("D")){
			newHead.y=head.y+CORRECTION_SHIFT;
			newHead.x=head.x;
		}
		
		if (direction.equals("U")){
			newHead.y=head.y-CORRECTION_SHIFT;
			newHead.x=head.x;
		}
	}
	
	void ReEmerge(Coordinate newHead){
		if (newHead.x==WIDTH){
			newHead.x=0;
		}
		if (newHead.x<0){
			newHead.x=WIDTH-CORRECTION_SHIFT;
		}
		if (newHead.y<0){
			newHead.y=HEIGHT-CORRECTION_SHIFT;
		}
		if (newHead.y==HEIGHT){
			newHead.y=0;
		}
	}
	
	boolean growSnake(Coordinate cor){
		if (cor.x==apple.x && cor.y==apple.y){
			randomizeApple();
			return true;
		} return false;
	}

	void randomizeApple(){
		do{
			apple.x = UIAuxiliaryMethods.getRandom(0, WIDTH-CORRECTION_SHIFT);
			apple.y = UIAuxiliaryMethods.getRandom(0, HEIGHT-CORRECTION_SHIFT);
		} while(snake.checkCollision(apple));
		ui.place(apple.x, apple.y, ui.FOOD);
		ui.showChanges();
	}
	
	public static void main(String[] args) {
		new playSnake().start();
	}
}
