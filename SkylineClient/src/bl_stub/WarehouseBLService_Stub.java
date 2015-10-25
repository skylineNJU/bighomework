package bl_stub;

import vo.InventoryVO;
import vo.WarehouseInVO;
import vo.WarehouseOutVO;
import vo.WarehouseOutVO.Type;
import businesslogicservice.WarehouseBLService;

public class WarehouseBLService_Stub implements WarehouseBLService{

	@Override
	public WarehouseInVO WarehouseIn(String code, String date, String to,
			char area, int row, int shelf, int position) {
		// TODO Auto-generated method stub
		WarehouseInVO warehouseInVO = new WarehouseInVO("01",date,code,"110020010001",to,area,row,shelf,position);
		
		return warehouseInVO;
	}

	@Override
	public WarehouseOutVO WarehouseOut(String code, String date, String to,
			Type transport, String TransitCode,String vehicleCode) {
		// TODO Auto-generated method stub
		WarehouseOutVO warehouseOutVO=new WarehouseOutVO("01", date,code,to, Type.plane,TransitCode,"025000001");
	//	String id, String da, String co,String a,String c,Type t,String d,String e
		return warehouseOutVO;
	}

	@Override
	//库存信息
	public InventoryVO showInventory(int inNum, int outNum, String orderCode, String damageCondition,char area,
				int row,int shelf,int position,String destination,String arriveDate) {
		// TODO Auto-generated method stub
		InventoryVO inventoryVO = new InventoryVO(100, 20,"0100210002","0",'A',1,2,3,"上海","20010201");
		return inventoryVO;
	}

}
