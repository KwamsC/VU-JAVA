package dasDS;

import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;
import ui.Event;
import ui.UIAuxiliaryMethods;
import java.net.ServerSocket;

public class Battlefield implements Runnable {
	final static int WIDTH = 25, HEIGHT = 25;
	final static int FPS = 5;
	SnakeUserInterface ui;
	static final int PORT= 7777;
	private ServerSocket serverSocket;
	private String url;
	private int port;
	private final int timeout = 1000;
	
	
	Battlefield(){
		ui = UserInterfaceFactory.getSnakeUI(WIDTH, HEIGHT);
		ui.setFramesPerSecond(FPS);
		Thread runnerThread = new Thread(this);
		runnerThread.start();

//		while (true){
//			Event event = ui.getEvent();
//			if (event.name.equals("alarm")){
//				ProcessAlarm(event);
//			} else if(event.name.equals("arrow")){
//				ProcessArrow(event);
//			}
//		}
	}
	
	Unit update(Unit cor){
		cor.x=+2;
		cor.y=+3;
		return cor;
	}
	
	public void place(int x, int y){
		ui.place(x, y, ui.SNAKE);
		ui.showChanges();
	}
	
	
	private void ProcessArrow(Event event) {
		// TODO Auto-generated method stub
		
	}

	private void ProcessAlarm(Event event) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args){
		new Battlefield();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
