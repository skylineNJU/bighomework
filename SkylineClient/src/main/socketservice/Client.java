package main.socketservice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import main.po.Message;

public class Client {
	private Socket socket;
	private ObjectOutputStream writer;
	private ClientThread clth;
	private ArrayList<Thread> threadList=new ArrayList<Thread>();
	public Client(){
		try{
			socket=new Socket("127.0.0.1",12345);
			System.out.println("get connection success");
			Thread thread=new Thread(clth=new ClientThread(socket));
			threadList.add(thread);
			System.out.println("thread create success");
			thread.start();
			System.out.println("net start success");
			writer=new ObjectOutputStream(socket.getOutputStream());
		}catch(Exception ex){
			System.out.println("net start failed");
		}
	}
	
	
	public boolean wrightReceipt(Message receipt){
		try {
			System.out.println(receipt==null);
			writer.writeObject(receipt);
			System.out.println("send successfully");
			writer.flush();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Message getResponse(){
		return clth.getResponseMessage();
	}
}
