package main.socketservice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.Queue;

import main.po.Message;

public class ClientThread implements Runnable {
	private ObjectInputStream reader; 
	private Message message;
	private Queue<Message> messageList=new LinkedList<Message>();
	public ClientThread(ObjectInputStream reader){
		this.reader=reader;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				if((message=(Message) reader.readObject())!=null){
					messageList.add(message);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Message getResponseMessage(){
			return messageList.poll();
	}
}
