package dasDS;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

//	Socket socket; //static because main method is static
//	ObjectInputStream in; // getting input from the server
//	ObjectOutputStream out; // Sending to the server

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException  {
		System.out.println("Connecting..");
		Socket socket = new Socket("localhost", Server.PORT1);
		System.out.println("Connection succesfull.");
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		Player c=new Player(1,1); 
		System.out.println(c.x +","+ c.y);
		out.writeObject(c);
		Player returnc=(Player)in.readObject();
		System.out.println(returnc.x +","+ returnc.y);
		
//		Input input = new Input(in);
//		Thread thread= new Thread(input);
//		thread.start();
//		Scanner sc= new Scanner(System.in);
//		System.out.println("Enter your name");
//		String name = sc.nextLine();
//		out.writeUTF(name);
//		while(true){
//			String sendMessage = sc.nextLine();
//			out.writeUTF(sendMessage);			
//		}
	}
}