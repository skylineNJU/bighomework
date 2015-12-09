package main.data.warehouse;

import java.util.ArrayList;

import main.dataservice.WarehouseDataService;
import main.po.InventoryList;
import main.po.InventoryPO;
import main.po.Message;
import main.po.WarehouseInList;
import main.po.WarehouseInPO;
import main.po.WarehouseOutList;
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
		warehouseInPO.setKey("Check");
		client.writeReceipt(warehouseInPO);
		Message message=client.getResponse();
		if(message.getKey().equals("success")){
			return true;
		}
		else return false;
	}
	@Override
	public boolean createWarehouseOutReceipt(WarehouseOutPO warehouseOutPO) {
		// TODO Auto-generated method stub

		warehouseOutPO.setKey("Check");
		client.writeReceipt(warehouseOutPO);
		Message message=client.getResponse();
		if(message.getKey().equals("success")){
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
		client.writeReceipt(Inventorylist);
		Inventorylist=(InventoryList) client.getResponse();
		return Inventorylist;
	}
	@Override
	public WarehouseInList inquireWarehouseIn(WarehouseInList warehouseInList) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		System.out.println(warehouseInList.getlist().get(0).getCode());
		warehouseInList.setKey("Inquire");
		client.writeReceipt(warehouseInList);
		warehouseInList=(WarehouseInList) client.getResponse();
		return warehouseInList;

	}
	@Override
	public WarehouseOutList inquireWarehouseOut(WarehouseOutList warehouseOutList) {
		// TODO Auto-generated method stub
		client=MainController.getClient();
		System.out.println(warehouseOutList.getlist().get(0).getCode());
		warehouseOutList.setKey("Inquire");
		client.writeReceipt(warehouseOutList);
		warehouseOutList=(WarehouseOutList) client.getResponse();
		return warehouseOutList;
	}

}