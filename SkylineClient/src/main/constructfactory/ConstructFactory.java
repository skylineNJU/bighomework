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
	
	public DistributeBLService DistributeFactory(){
		return new DistributeController();	
	}
	
	public FinanceBLService FinanceFactory(){
		return new FinanceController();	
	}
	
	public GuestBLService GuestFactory(){
		return new GuestController();	
	}
	
	public InfoBLService InfoFactory(){
		return new InfoController();	
	}
	
	public LoadBLService LoadFactory(){
		return new LoadController();	
	}
	
	public ReceiptBLService ReceiptFactory(){
		return new ReceiptController();	
	}
	
	public ReceiveBLService ReceiveFactory(){
		return new ReceiveController();	
	}
	
	public RightBLService RightFactory(){
		return  new RightController();	
	}
	
	public WarehouseBLService WarehouseFactory(){
		return new WarehouseController();	
	}
}
