package test.bl_stub;

import java.util.ArrayList;

import main.po.InventoryPO;
import main.po.WarehouseInPO;
import main.po.WarehouseOutPO;
import main.vo.InventoryVO;
import main.vo.WarehouseInVO;
import main.vo.WarehouseOutVO;
import main.State.TransType;
import main.businesslogicservice.WarehouseBLService;
/**
 * 
 * @author QiHan
 * 
 *
 */
public class WarehouseBLService_Stub implements WarehouseBLService{

	@Override
	public boolean WarehouseIn(WarehouseInVO warehouseInInfo) {
		// TODO Auto-generated method stub
		
		warehouseInInfo = new WarehouseInVO("01190001710000", "1235665", "2015/02/08", "上海", "A", 1, 1, 2, "完好");
		if(warehouseInInfo.getCode()!=null)
			return true;
		else return false;
	}

	@Override
	public boolean WarehouseOut(WarehouseOutVO warehouseOutInfo) {
		// TODO Auto-generated method stub
		 warehouseOutInfo = new WarehouseOutVO("01190001720000", "8652131", "北京", "2018/09/09", TransType.PLANE , "0100", "025000001", "完好");
		 if(warehouseOutInfo.getCode()!=null)
			 return true;
		else return false;
	}

	@Override
	public boolean showInventory(String startdate, String enddate,
			InventoryVO inventoryInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<WarehouseInVO> showWarehouseInInfo(String code) {
		// TODO Auto-generated method stub
		WarehouseInVO outVo= new WarehouseInVO("0119000172150000","A",1,1,1);
		ArrayList<WarehouseInVO> WarehouseInVOlist = new ArrayList<WarehouseInVO>();
		WarehouseInVOlist.add(outVo);
		return WarehouseInVOlist;
	}

	@Override
	public ArrayList<WarehouseOutVO> showWarehouseOutInfo(String code) {
		// TODO Auto-generated method stub
		WarehouseOutVO outVo= new WarehouseOutVO("0119000172250000","A",1,1,1);
		ArrayList<WarehouseOutVO> WarehouseOutVOlist = new ArrayList<WarehouseOutVO>();
		WarehouseOutVOlist.add(outVo);
		return WarehouseOutVOlist;
	}

	@Override
	public ArrayList<InventoryVO> checkInventory(String code) {
		// TODO Auto-generated method stub
		InventoryVO inventory = new InventoryVO("0119000172150000","2015年02月02日","上海","A",1,1,1);
		ArrayList<InventoryVO> Inventorylist = new ArrayList<InventoryVO>();
		Inventorylist.add(inventory);
		return Inventorylist;
	}


}
