package socketservice;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import po.LobbyReceivePO;

public class Server {
	ServerSocket ss;
	ServerHander hander=new ServerHander();
	public Server(){
		try {
			ss=new ServerSocket(12345);
			System.out.println("server start");
			while(true){
			Socket socket=ss.accept();
			ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			run(socket,ois);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(Socket socket,ObjectInputStream ois){
		try {
			Object po=ois.readObject();
			hander.analysis(po);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	public static void main(String args[]){
		Server se=new Server();
	}
}
