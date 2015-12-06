package main.data.warehouse;

import java.util.ArrayList;

import main.dataservice.RightDataService;
import main.dataservice.WarehouseDataService;
import main.State.RightType;
import main.po.AccountPO;
import main.po.DriverList;
import main.po.InventoryList;
import main.po.InventoryPO;
import main.po.Message;
import main.po.WarehouseInList;
import main.po.WarehouseInPO;
import main.po.WarehouseOutPO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;

public class WarehouseDataController implements WarehouseDataService{

	private Client client;
	public WarehouseDataController(){
		client=MainController.getClient();
	}
	@Override
	public boolean storage(WarehouseInPO warehouseInPO) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean outWarehouse(WarehouseOutPO warehouseOutPO) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean readWarehouse(String warehouseNumber,
			ArrayList<InventoryPO> inventoryPOList) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean createWarehouseInReceipt(WarehouseInPO warehouseInPO) {
		// TODO Auto-generated method stub
		warehouseInPO.setKey("Save");
		client.wrightReceipt(warehouseInPO);
		return true;
	}
	@Override
	public boolean createWarehouseOutReceipt(WarehouseOutPO warehouseOutPO) {
		// TODO Auto-generated method stub
		warehouseOutPO.setKey("Check");
		client.wrightReceipt(warehouseOutPO);
		Message message=client.getResponse();
		
		warehouseOutPO=(WarehouseOutPO) message;
		if(warehouseOutPO.getKey().equals("success")){
			return true;
		}
		else return false;
		 
	}
	@Override
	public InventoryList inquireInventory(InventoryList Inventorylist) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		System.out.println(Inventorylist.getlist().get(0).getOrderCode());
		Inventorylist.setKey("Inquire");
		client.wrightReceipt(Inventorylist);
		Inventorylist=(InventoryList) client.getResponse();
		return Inventorylist;
	}
	@Override
	public WarehouseInList inquireWarehouseIn(WarehouseInList warehouseInList) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		System.out.println(warehouseInList.getlist().get(0).getCode());
		warehouseInList.setKey("Inquire");
		client.wrightReceipt(warehouseInList);
		warehouseInList=(WarehouseInList) client.getResponse();
		return warehouseInList;
		
	}

}