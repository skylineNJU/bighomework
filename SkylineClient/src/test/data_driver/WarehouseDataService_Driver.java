package test.data_driver;

import java.util.ArrayList;

import main.State.TransType;
import main.businesslogic.warehousebl.Inventory;
import main.dataservice.WarehouseDataService;
import main.po.InventoryPO;
import main.po.WarehouseInPO;
import main.po.WarehouseOutPO;

public class WarehouseDataService_Driver {
 
	public boolean warhouseDrive(WarehouseDataService warehouseDataService){
		
		WarehouseInPO warehouseInPO = new WarehouseInPO("01190001710000", "1235665", "2015/02/08", "�Ϻ�", "A", 1, 1, 2, "���");
		WarehouseOutPO warehouseOutPO = new WarehouseOutPO("01190001720000", "8652131", "����", "2018/09/09", TransType.PLANE , "0100", "025000001", "���");
		InventoryPO inventory = new InventoryPO(10, 6, "211323", "���", "B", 1, 3, 4, "�Ϻ�", "2016/01/01");
		ArrayList<InventoryPO> inventoryPOList = null;
		inventoryPOList.add(inventory);
		
		String warehouseNumber = "20151515";
		
		if(warehouseDataService.storage(warehouseInPO)){
			System.out.println("----storage succeed!-----");
		}
		if(warehouseDataService.outWarehouse(warehouseOutPO)){
			System.out.println("----outWarehouse succeed!-----");
		}
		if(warehouseDataService.readWarehouse(warehouseNumber,inventoryPOList)){
			System.out.println("----readWarehouse succeed!-----");
		}
		return true;
	} 
}
