package main.socketservice;

import java.io.IOException;
import java.io.ObjectOutputStream;

import main.po.AccountPO;
import main.po.Message;

public class ClientController {
	private Message message;
	private ObjectOutputStream writer;
	
	public ClientController(ObjectOutputStream writer){
		this.writer=writer;
	}
	
    public void analysis(Message obj){
    	message=obj;
    	
    	switch(message.getKey()){
    	case "Save":
    		message.writeIntoDatabase();
    		break;
    	case "Inquire":
    		message.getDataFromBase();
    		response(message);
    		break;
    	case "Start":
    		AccountPO po=(AccountPO)message;
    		po.checkLogin();
    		response(po);
    	case "End":
    		break;
    	}

    }
    
    public void response(Message message){
    	try {
			writer.writeObject(message);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
