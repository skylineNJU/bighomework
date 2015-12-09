package main.businesslogic.infobl;

import main.data.info.InfoDataController;
import main.dataservice.InfoDataService;
import main.po.WarehouseInfo;
import main.vo.WarehouseInfoVO;

public class WarehouseInfoBL {
	private WarehouseInfo info;
	
	public WarehouseInfoBL(WarehouseInfoVO vo){
		info=new WarehouseInfo(vo.getCity(),vo.getStaffNum()
				,vo.getAcreage(),vo.getArea(),vo.getAlert());
	}
	public void saveInfo(){
		InfoDataService service=new InfoDataController();
		service.addWarehouse(info);
	}
	
	public void delete(){
		InfoDataService service=new InfoDataController();
		service.deleteWarehouse(info);
	}
}
