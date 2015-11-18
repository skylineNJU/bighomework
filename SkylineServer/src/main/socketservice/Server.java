package main.socketservice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	ServerSocket ss;
	ClientController hander=new ClientController();
	ArrayList<Thread> threadList=new ArrayList<Thread>();
	public void start(){
		try {
			ss=new ServerSocket(12345);
			System.out.println("server start");
			while(true){
			Socket socket=ss.accept();
			Thread clientThread=new Thread(new ClientHander(socket));
			threadList.add(clientThread);
			clientThread.start();
			System.out.println("got a connection");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		Server se=new Server();
		se.start();
	}
}
