package socketservice;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import po.LobbyReceivePO;
import po.Message;

public class Client {
	Socket socket;
	ObjectOutputStream obOut;
	
	public Client(){
		try{
			socket=new Socket("127.0.0.1",12345);
			
		}catch(Exception ex){
			System.out.println("net start failed");
		}
	}
	
	public boolean wrightReceipt(Message receipt){
		try {
			obOut=new ObjectOutputStream(socket.getOutputStream());
			 obOut.writeObject(receipt);
			System.out.println("send successfully");
			obOut.flush();
			obOut.close();
			socket.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
}
