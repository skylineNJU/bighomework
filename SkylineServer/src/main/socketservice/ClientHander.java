package main.socketservice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import main.po.Message;

public class ClientHander implements Runnable{
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private Socket socket;
	private ClientController messagein;
	public ClientHander(Socket clientSocket){
		try{
			socket=clientSocket;
			reader=new ObjectInputStream(socket.getInputStream());
			writer=new ObjectOutputStream(socket.getOutputStream());
			messagein=new ClientController(writer);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Message message;
		while(true){
			try {
				if((message=(Message) reader.readObject())!=null){
					System.out.println("get a message");
					messagein.analysis(message);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				try {
					socket.close();
					System.out.println("a socket closed");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					socket.close();
					System.out.println("a socket closed");
					break;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			} catch(Exception ex){
				try {
					socket.close();
					System.out.println("a socket closed");
					break;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			}
		}
	}

}
