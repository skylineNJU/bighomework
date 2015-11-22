package main.socketservice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
			reader=new ObjectInputStream(
					new BufferedInputStream(socket.getInputStream()));
			writer=new ObjectOutputStream(
					new BufferedOutputStream(socket.getOutputStream()));
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
					messagein.analysis(message);
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

}
