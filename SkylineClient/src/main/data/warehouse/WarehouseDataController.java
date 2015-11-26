package main.data.warehouse;

import java.util.ArrayList;

import main.dataservice.RightDataService;
import main.dataservice.WarehouseDataService;
import main.State.RightType;
import main.po.AccountPO;
import main.po.InventoryPO;
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
		
		return false;
	}
	@Override
	public boolean createWarehouseOutReceipt(WarehouseOutPO warehouseOutPO) {
		// TODO Auto-generated method stub
		return false;
	}

}