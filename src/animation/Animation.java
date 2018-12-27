package animation;
import ui.Event;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;
import java.io.PrintStream;

public class Animation {
	final static int 	WIDTH=40,	HEIGHT=30;				
	final static double FRAMES_PER_SECOND = 20.0, 	SPEED_CONTROL = 0.5;
	SnakeUserInterface ui;	
	PrintStream out;
	int x;
	int y;
	int z;
	double frames;
	
	public Animation() {
		ui = UserInterfaceFactory.getSnakeUI(WIDTH, HEIGHT);
		out = new PrintStream(System.out);
		frames=FRAMES_PER_SECOND;
		ui.setFramesPerSecond(frames);
		x=0;
		y=0;
		z=1;	
	}
	
	private void ProcessEvent(Event event) {
		ui.place(x,y,1);
		if (event.name.equals("alarm") && x<WIDTH && y<29){
			ui.place(x,y,0);
			x++;
			if (x>=WIDTH){
				x=0;
				y++;				
			}
			ui.place(x,y,z);	
			if (y>=HEIGHT-1){
				y=0;
			}	
		} 
		if (event.data.equals("g") && z==1){
			z=2;
		} else if(event.data.equals("g") && z==2){
			z=1;
		}	
		if (event.data.equals("R")){
			ui.setFramesPerSecond(frames+=0.5);
		} else if(event.data.equals("L")){
			ui.setFramesPerSecond(frames-=0.5);
		}	
	}
	
	
	void start(){
		while(true){
			Event event = ui.getEvent();
			ProcessEvent(event);

			ui.showChanges();
		}
	}

	public static void main(String[] args) {
		new Animation().start();
	}

}
