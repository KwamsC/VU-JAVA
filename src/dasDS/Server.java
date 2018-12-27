package dasDS;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;

public class Server {
	private ServerSocket sS;
	static Socket socket;
	static final int PORT1 = 7777;
	static Users[] user=new Users[10];
	private ArrayList <Unit> units; 

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		new Server().runServer();
		//		System.out.println("server started..");
		//		while(true){
		//			socket = sS.accept();
		//			for (int i=0; i<10; i++){
		//				System.out.println("connection from" + socket.getInetAddress());
		//				out=new DataOutputStream(socket.getOutputStream());
		//				out.writeUTF("This is a test of java sockets.");
		//				System.out.println("Data has been sent");
		//				in= new DataInputStream(socket.getInputStream());
		//				if (user[i]==null){
		//					user[i]=new Users(out, in, user);
		//					Thread thread = new Thread(user[i]);
		//					thread.start();
		//					break;
		//				}
		//			}
		//		}
	}

	private void runServer() throws IOException, ClassNotFoundException {
		System.out.println("Starting server...");
		sS = new ServerSocket(PORT1);
		System.out.println(PORT1+" server started..");
		socket = sS.accept();
		System.out.println("connection from" + socket.getInetAddress());
		Battlefield ui =new Battlefield();
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream out= new ObjectOutputStream(socket.getOutputStream());
		Unit c=(Unit)in.readObject();
		ui.place(c.x, c.y);
		System.out.println(c.x+","+c.y);
		c=ui.update(c);
		out.writeObject(c);
		ui.place(c.x, c.y);
		System.out.println(c.x+","+c.y);

	}
}