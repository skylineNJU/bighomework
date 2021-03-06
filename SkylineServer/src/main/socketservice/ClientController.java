package main.socketservice;

import java.io.IOException;
import java.io.ObjectOutputStream;

import main.po.AccountPO;
import main.po.BuildAccountPO;
import main.po.Message;

public class ClientController {
	private Message message;
	private ObjectOutputStream writer;
	
	public ClientController(ObjectOutputStream writer){
		this.writer=writer;
	}
	
    public void analysis(Message obj){
    	message=obj;
    	System.out.println(message.getKey());
    	switch(message.getKey()){
    	case "Modify":
    	    message.modifyTheDate();
    		break;
    	case "Check":
    		message.writeIntoDatabase();
    		response(message);
    		break;
    	case "Save":
    		message.writeIntoDatabase();
    		break;
    	case "Inquire":
    		message.getDataFromBase();
    		response(message);
    		break;
    	case "Delete":
    		System.out.println("get a delete mission");
    		message.deleteFromDatabase();
    		break;
    	case "Start":
    		AccountPO po=(AccountPO)message;
    		po.checkLogin();
    		response(po);
    		break;
    	case "Load":
    		BuildAccountPO po1=(BuildAccountPO) message;
    		po1.Load();
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
