package socketservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import po.LobbyReceivePO;
import po.Message;

public class ServerHander {
	Message receipt;
	File file;
    public void analysis(Object obj){
    	receipt=(Message) obj;
    	switch(receipt.getType()){
    	case LobbyReceive:
    		file=new File("src/database/Receive.dat");
			try {
				ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
				out.writeObject(receipt);
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case Account:
			break;
		case Approval:
			break;
		case BankAccount:
			break;
		case CenterReceive:
			break;
		case Clearing:
			break;
		case Collection:
			break;
		case Cost:
			break;
		case Distribute:
			break;
		case DriverInfo:
			break;
		case Institution:
			break;
		case Inventory:
			break;
		case Loading:
			break;
		case Message:
			break;
		case Order:
			break;
		case PlaneLoading:
			break;
		case Receive:
			break;
		case Rights:
			break;
		case Salary:
			break;
		case StaffReceipt:
			break;
		case TrainLoading:
			break;
		case VehicleInfo:
			break;
		case VehicleLoading:
			break;
		case WarehouseIn:
			break;
		case WarehouseOut:
			break;
		case Worker:
			break;
		default:
			break;
    		
    	}
    	
    	
    }
}
