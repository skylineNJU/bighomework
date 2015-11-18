package test.data_driver;

import java.util.ArrayList;

import main.businesslogic.warehousebl.Inventory;
import main.dataservice.WarehouseDataService;
import main.po.InventoryPO;
import main.po.WarehouseInPO;
import main.po.WarehouseOutPO;

public class WarehouseDataService_Driver {
 
	public boolean warhouseDrive(WarehouseDataService warehouseDataService){
		
		WarehouseInPO warehouseInPO = new WarehouseInPO("123456789", "2015/02/26", "北京", 'A', 1, 2, 3);
		WarehouseOutPO warehouseOutPO = new WarehouseOutPO("123456789", "2015/02/23", "北京", null, "2012151", "201515");
		InventoryPO inventory = new Inventory();
		ArrayList<InventoryPO> inventoryPOList;
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
