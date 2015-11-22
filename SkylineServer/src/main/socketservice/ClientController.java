package main.socketservice;

import main.po.AccountPO;
import main.po.ApprovalPO;
import main.po.BankAccountPO;
import main.po.CenterReceivePO;
import main.po.LobbyReceivePO;
import main.po.Message;

public class ClientController {
	private Message message;

    public void analysis(Message obj){
    	message=obj;
    	
    	switch(message.getKey()){
    	case "Start":
    		AccountPO account=(AccountPO)message;
    		break;
    	case "End":
    		break;
    		
    	}
//    	switch(message.getType()){
//    	case LobbyReceive:
//    		LobbyReceivePO lobbyReceive=(LobbyReceivePO)message;
//    		break;
//		case Account:
//			AccountPO Account=(AccountPO)message;
//			break;
//		case Approval:
//			ApprovalPO approval=(ApprovalPO)message;
//			break;
//		case BankAccount:
//			BankAccountPO bankAccount=(BankAccountPO)message;
//			break;
//		case CenterReceive:
//			CenterReceivePO centerReceive=(CenterReceivePO)message;
//			break;
//		case Clearing:
//			
//			break;
//		case Collection:
//			break;
//		case Cost:
//			break;
//		case Distribute:
//			break;
//		case DriverInfo:
//			break;
//		case Institution:
//			break;
//		case Inventory:
//			break;
//		case Loading:
//			break;
//		case Message:
//			break;
//		case Order:
//			break;
//		case PlaneLoading:
//			break;
//		case Receive:
//			break;
//		case Rights:
//			break;
//		case Salary:
//			break;
//		case StaffReceipt:
//			break;
//		case TrainLoading:
//			break;
//		case VehicleInfo:
//			break;
//		case VehicleLoading:
//			break;
//		case WarehouseIn:
//			break;
//		case WarehouseOut:
//			break;
//		case Worker:
//			break;
//		default:
//			break;
//    		
//    	}
//    	
//    	
    }
}
