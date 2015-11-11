package data_driver;

import dataService.WarehouseDataService;
import po.WarehouseInPO;
import po.WarehouseOutPO;

public class WarehouseDataService_Driver {
 
	public boolean warhouseDrive(WarehouseDataService warehouseDataService){
		
		WarehouseInPO warehouseInPO = new WarehouseInPO("123456789", "2015/02/26", "北京", "A", 1, 2, 3);
		WarehouseOutPO warehouseOutPO = new WarehouseOutPO("123456789", "2015/02/23", "北京", null, "2012151", "201515");
		String warehouseNumber = "20151515";
		
		if(warehouseDataService.storage(warehouseInPO)){
			System.out.println("----storage succeed!-----");
		}
		if(warehouseDataService.outWarehouse(warehouseOutPO)){
			System.out.println("----outWarehouse succeed!-----");
		}
		if(warehouseDataService.readWarehouse(warehouseNumber)!=null){
			System.out.println("----readWarehouse succeed!-----");
		}
		return true;
	} 
}
