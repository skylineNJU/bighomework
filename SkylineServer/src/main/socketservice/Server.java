package main.socketservice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket ss;
	public void start(){
		try {
			ss=new ServerSocket(12345);
			System.out.println("server start");
			while(true){
			Socket socket=ss.accept();
			Thread clientThread=new Thread(new ClientHander(socket));
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
