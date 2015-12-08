package test.bl_driver;

import  main.vo.InventoryVO;
import  main.vo.WarehouseInVO;
import  main.vo.WarehouseOutVO;
import main.State.TransType;
import main.businesslogic.warehousebl.Inventory;
import  main.businesslogicservice.WarehouseBLService;

public class WarehouseBLService_Driver {
	public void drive(WarehouseBLService warehouseBLService){
		//String code, String area, int row, int shelf,int position
		WarehouseInVO warehouseIn =new WarehouseInVO("1111555555","µØÇø",1,1,3);
		WarehouseOutVO warehouseOut=new WarehouseOutVO("", "", 0, 0, 0);
		if(warehouseBLService.WarehouseIn(warehouseIn)){
			System.out.println("--------------Warehouse In-------------");
		}
		
		
		if(warehouseBLService.WarehouseOut(warehouseOut)){
			System.out.println("--------------Warehouse Out--------------");
		}
		
		InventoryVO inventory = new InventoryVO(0, 0, "", "", "", 0, 0, 0, "", "");
		if(warehouseBLService.showInventory("20150601", "20150603", inventory)){
			System.out.println("--------------Inventory Show--------------");
		}
		String code="131415";
	
		if(warehouseBLService.showWarehouseInInfo(code)!=null){
			System.out.println("--------------WarehouseIn Showing-------------");
		}
		if(warehouseBLService.showWarehouseOutInfo(code)!=null){
			System.out.println("--------------WarehouseOut Showing-------------");
		}
		if(warehouseBLService.checkInventory(code)!=null){
			System.out.println("--------------Inventory Check-------------");
		}
	}
}
