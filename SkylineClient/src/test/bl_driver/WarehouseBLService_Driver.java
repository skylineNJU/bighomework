package test.bl_driver;

import java.util.ArrayList;

import  main.vo.InventoryVO;
import  main.vo.WarehouseInVO;
import  main.vo.WarehouseOutVO;
import main.State.TransType;
import main.businesslogic.warehousebl.Inventory;
import  main.businesslogicservice.WarehouseBLService;

public class WarehouseBLService_Driver {
	public void drive(WarehouseBLService warehouseBLService){


		//String code, String area, int row, int shelf,int position
		WarehouseInVO warehouseIn =new WarehouseInVO("01190001710000", "1235665", "2015/02/08", "上海", "A", 1, 1, 2, "完好");
		WarehouseOutVO warehouseOut=new WarehouseOutVO("01190001720000", "8652131", "北京", "2018/09/09", TransType.PLANE , "0100", "025000001", "完好");
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
