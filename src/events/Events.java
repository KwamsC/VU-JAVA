package events;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;
import ui.Event;
import java.io.PrintStream;
import java.util.Scanner;
public class Events {
	final static int 	WIDTH=40,
						HEIGHT=30;
	SnakeUserInterface ui;	
	PrintStream out;
	
	public Events() {
		ui = UserInterfaceFactory.getSnakeUI(WIDTH, HEIGHT);
		out = new PrintStream(System.out);
	}
	
	private void ProcessEvent(Event event) {
		if (event.name.equals("click")){
			ProcesClick(event.data);
		} else if(event.data.equals("␣")){
			ui.clear();
		}
		ui.showChanges();	
	}
	
	private void ProcesClick(String data) {
		Scanner in = new Scanner(data);
		int x = in.nextInt();
		int y = in.nextInt();
		ui.place(x, y, 1);
	}

	void start(){
		while(true){
			Event event = ui.getEvent();
			ProcessEvent(event);
			out.printf("%s\n", event.data);	
		}
	}

	public static void main(String[] args) {
		new Events().start();
	}

}
