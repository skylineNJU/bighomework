package bl_driver;

import vo.InventoryVO;
import vo.WarehouseInVO;
import vo.WarehouseOutVO;
import vo.WarehouseOutVO.Type;
import businesslogicservice.WarehouseBLService;

public class WarehouseBLService_Driver {
	public void drive(WarehouseBLService warehouseBLService){
		WarehouseInVO warehouseIn =warehouseBLService.WarehouseIn("01","20010101","110020010001",'A',1,2,3);
		if(warehouseIn != null){
			System.out.println("--------------WarehouseInOrder Showing-------------");
		}
		
		WarehouseOutVO warehouseOutVO = warehouseBLService.WarehouseOut("10101", "20010101", "上海", Type.plane,"0101010","025000001");
		if(warehouseOutVO != null){
			System.out.println("--------------WarehouseOutOrder Showing--------------");
		}
		
	
		InventoryVO inventory = warehouseBLService.showInventory(100, 20, "0100210002","0",'A',1,2,3,"上海","20010201");
		if(inventory!= null){
			System.out.println("--------------Inventory Showing-------------");
		}
		
	}
}
