package main.businesslogic.warehousebl;


import java.util.ArrayList;

import main.po.InventoryList;
import main.vo.DriverVO;
import main.vo.InventoryVO;
import main.vo.WarehouseInVO;
import main.vo.WarehouseOutVO;
import main.businesslogic.infobl.Driver;
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
	public ArrayList<InventoryVO> checkInventory(String code) {
		// TODO Auto-generated method stub
		Inventory inventory=new Inventory(code);
		ArrayList<InventoryVO> ivo=inventory.inquire(code);
		return ivo;
	}

	@Override
	public ArrayList<WarehouseInVO> showWarehouseInInfo(String code) {
		// TODO Auto-generated method stub
		WarehouseIn in=new WarehouseIn(code);
		ArrayList<WarehouseInVO> invo=in.inquire(code);
		return invo;
	}

	@Override
	public ArrayList<WarehouseOutVO> showWarehouseOutInfo(String code) {
		// TODO Auto-generated method stub
		WarehouseOut out=new WarehouseOut();
		ArrayList<WarehouseOutVO> outvo=out.inquire(code);
		return outvo;
	}

}
