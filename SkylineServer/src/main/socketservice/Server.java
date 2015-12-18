package main.socketservice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import main.serverFrame.MyButton;
import main.serverFrame.MyFrame;

public class Server {
	private ServerSocket ss;
	public void start(){
		try {
//			Timer timer=new Timer();
//			timer.schedule(new TimerTask(),new Date());
//			System.out.println("timer start success");
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
		MyFrame frame = new MyFrame(400,200);
		MyButton button = new MyButton();
		button.setIMG(imgEnter, imgExit, imgPress);
		Server se=new Server();
		se.start();
	
	}
}