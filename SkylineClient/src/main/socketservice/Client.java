package main.socketservice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import main.po.Message;

public class Client {
	private Socket socket;
	private ObjectOutputStream writer;
	private ObjectInputStream reader;
	public Client(){
		try{
			socket=new Socket("127.0.0.1",12345);
			reader=new ObjectInputStream(socket.getInputStream());
			Thread thread=new Thread(new ClientThread(reader));
			thread.start();
		}catch(Exception ex){
			System.out.println("net start failed");
		}
	}
	
	public boolean wrightReceipt(Message receipt){
		try {
			writer=new ObjectOutputStream(socket.getOutputStream());
			writer.writeObject(receipt);
			System.out.println("send successfully");
			writer.flush();
			writer.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
}
