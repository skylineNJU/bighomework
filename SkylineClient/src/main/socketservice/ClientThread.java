package main.socketservice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import main.po.Message;

public class ClientThread implements Runnable {
	private ObjectInputStream reader; 
	private Message message;
	private BlockingQueue<Message> messageList=new LinkedBlockingQueue<Message>();
	private Socket socket;
	public ClientThread(Socket socket){
		this.socket=socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			reader=new ObjectInputStream(socket.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			System.out.println(socket.isClosed());
			while(true){
				message=(Message)reader.readObject();
				if(message!=null){
					System.out.println("get message,and key is:"+message.getKey());
				try {
					messageList.put(message);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				System.out.println(socket.isClosed());
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Message getResponseMessage(){
		System.out.println("waiting.....");
		Message message=null;
		try {
			message = messageList.take();
			messageList.clear();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("take a message");
		System.out.println(message.getKey());
		return message;
	}
}
