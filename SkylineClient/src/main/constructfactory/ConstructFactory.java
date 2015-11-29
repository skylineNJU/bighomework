package main.constructfactory;

import main.businesslogic.distributebl.DistributeController;
import main.businesslogic.financebl.FinanceController;
import main.businesslogic.guestbl.GuestController;
import main.businesslogic.infobl.InfoController;
import main.businesslogic.loadbl.LoadController;
import main.businesslogic.receiptbl.ReceiptBLController;
import main.businesslogic.receivebl.ReceiveController;
import main.businesslogic.rightbl.RightController;
import main.businesslogic.warehousebl.WarehouseController;
import main.businesslogicservice.*;
import main.businesslogicservice.receiptblService.CourrierReceipt;
import main.businesslogicservice.receiptblService.FinanceReceipt;
import main.businesslogicservice.receiptblService.IntermediateReceipt;
import main.businesslogicservice.receiptblService.LobbyReceipt;
import main.businesslogicservice.receiptblService.ReceiptCode;
import main.businesslogicservice.receiptblService.SubmitReceipt;
import main.businesslogicservice.receiptblService.WarehouseReceipt;

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
	
	
	static 	public ReceiveBLService ReceiveFactory(){
		return new ReceiveController();	
	}
	
	static 	public RightBLService RightFactory(){
		return  new RightController();	
	}
	
	static 	public WarehouseBLService WarehouseFactory(){
		return new WarehouseController();	
	}
	
	static public WarehouseReceipt WarehouseReceiptFactory(){
		return new ReceiptBLController();	
	}
	public static CourrierReceipt CourrierReceiptFactory(){
		return new ReceiptBLController();
	}
	
	public static ReceiptCode calculateCode(){
		return new ReceiptBLController();
	}
	
	public static FinanceReceipt FinanceReceiptFactory(){
		return new ReceiptBLController();
	}
	
	public static IntermediateReceipt IntermediateFactory(){
		return new ReceiptBLController();
	}
	
	public static LobbyReceipt LobbyReceiptFactory(){
		return new ReceiptBLController();
	}
	
	public static SubmitReceipt SubMitFactory(){
		return new ReceiptBLController();
	}
}
