package main.businesslogic.warehousebl;


import main.vo.InventoryVO;
import main.vo.WarehouseInVO;
import main.vo.WarehouseOutVO;
import main.businesslogicservice.WarehouseBLService;

public class WarehouseController implements WarehouseBLService {

	@Override
	public boolean WarehouseIn(WarehouseInVO warehouseInInfo) {
		// TODO Auto-generated method stub
		WarehouseIn warehouseIn = new WarehouseIn(warehouseInInfo);
		return warehouseIn.saveInfo();
	}

	@Override
	public boolean WarehouseOut(WarehouseOutVO warehouseOutInfo) {
		// TODO Auto-generated method stub
		WarehouseOut warehouseOut = new WarehouseOut(warehouseOutInfo);
		return warehouseOut.saveInfo();
	}

	@Override
	public boolean showInventory(String startdate, String enddate,
			InventoryVO inventoryInfo) {
		// TODO Auto-generated method stub
		Inventory showinventory = new Inventory(inventoryInfo);
		return showinventory.show();
	}

	@Override
	public boolean checkInventory(WarehouseInVO checkinventoryInfo) {
		// TODO Auto-generated method stub
		WarehouseIn checkinventory = new WarehouseIn(checkinventoryInfo);
		return checkinventory.check();
	}

}
