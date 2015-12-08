package test.bl_driver;

import java.util.ArrayList;

import  main.vo.InventoryVO;
import  main.vo.WarehouseInVO;
import  main.vo.WarehouseOutVO;
import main.State.TransType;
import  main.businesslogicservice.WarehouseBLService;

public class WarehouseBLService_Driver {
	public void drive(WarehouseBLService warehouseBLService){
		
		WarehouseInVO in = new WarehouseInVO("01190001710000", "1235665", "2015/02/08", "上海", "A", 1, 1, 2, "完好");
		boolean warehouseIn =warehouseBLService.WarehouseIn(in);
		if(warehouseIn ){
			System.out.println("--------------WarehouseInOrder Showing-------------");
		}
		WarehouseOutVO out = new WarehouseOutVO("01190001720000", "8652131", "北京", "2018/09/09", TransType.PLANE , "0100", "025000001", "完好");
		boolean warehouseOutVO = warehouseBLService.WarehouseOut(out);
		if(warehouseOutVO){
			System.out.println("--------------WarehouseOutOrder Showing--------------");
		}

		ArrayList<InventoryVO>  inventory =warehouseBLService.checkInventory("123243");
		if(inventory != null){
			System.out.println("--------------Inventory Showing-------------");
		}
		
	}
}
