package main.constructfactory;

import main.businesslogic.distributebl.DistributeController;
import main.businesslogic.financebl.FinanceController;
import main.businesslogic.guestbl.GuestController;
import main.businesslogic.infobl.InfoController;
import main.businesslogic.loadbl.LoadController;
import main.businesslogic.receiptbl.ReceiptController;
import main.businesslogic.receivebl.ReceiveController;
import main.businesslogic.rightbl.RightController;
import main.businesslogic.warehousebl.WarehouseController;
import main.businesslogicservice.*;

public class ConstructFactory {
	
	static public DistributeBLService DistributeFactory(){
		return new DistributeController();	
	}
	
	static 	public FinanceBLService FinanceFactory(){
		return new FinanceController();	
	}
	
	static 	public GuestBLService GuestFactory(){
		return new GuestController();	
	}
	
	static 	public InfoBLService InfoFactory(){
		return new InfoController();	
	}
	
	static 	public LoadBLService LoadFactory(){
		return new LoadController();	
	}
	
	static 	public ReceiptBLService ReceiptFactory(){
		return new ReceiptController();	
	}
	
	static 	public ReceiveBLService ReceiveFactory(){
		return new ReceiveController();	
	}
	
	static 	public RightBLService RightFactory(){
		return  new RightController();	
	}
	
	static 	public WarehouseBLService WarehouseFactory(){
		return new WarehouseController();	
	}
}
