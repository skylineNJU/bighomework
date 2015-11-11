package businesslogic.warehousebl;

import vo.InventoryVO;
import vo.WarehouseInVO;
import vo.WarehouseOutVO;
import vo.WarehouseOutVO.Type;
import businesslogicservice.WarehouseBLService;

public class WarehouseController implements WarehouseBLService {

	@Override
	public WarehouseInVO WarehouseIn(String code, String date, String to,
			char area, int row, int shelf, int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WarehouseOutVO WarehouseOut(String code, String date, String to,
			Type transport, String TransitCode, String vehicleCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryVO checkInventory(String startdate, String enddate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryVO showInventory() {
		// TODO Auto-generated method stub
		return null;
	}

}
