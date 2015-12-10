package main.businesslogic.infobl;

import java.util.ArrayList;

import main.data.info.InfoDataController;
import main.dataservice.InfoDataService;
import main.po.IntermediateInfo;
import main.po.WarehouseInfo;
import main.vo.IntermediateInfoVO;
import main.vo.WarehouseInfoVO;

public class IntermediateInfoBL {
	private IntermediateInfo intermInfo;
	
	public IntermediateInfoBL(IntermediateInfoVO intermvo){
		intermInfo=new IntermediateInfo(intermvo.getCity(),intermvo.getInstitutionCode()
				,intermvo.getArea(),intermvo.getStaffNum());
		ArrayList<WarehouseInfoVO> voList=intermvo.getWarehouseInfoList();
		for(WarehouseInfoVO vo:voList){
			intermInfo.addWarehouse(new WarehouseInfo(vo.getCity(),vo.getStaffNum()
					,vo.getAcreage(),vo.getArea(),vo.getAlert()));
		}
	}
	
	public void saveInfo(){
		InfoDataService service=new InfoDataController();
		service.addIntermediate(intermInfo);
	}
	
	public void delete(){
		InfoDataService service=new InfoDataController();
		service.deleteIntermediate(intermInfo);
	}
	
	public void modify(){
		InfoDataService service=new InfoDataController();
		service.modifyIntermediate(intermInfo);
	}
	
	public IntermediateInfoVO inquire(){
		InfoDataService service=new InfoDataController();
		intermInfo=service.inquireInterm(intermInfo);
		IntermediateInfoVO vo=new IntermediateInfoVO(
				intermInfo.getCity(),intermInfo.getInstitutionCode(),
				intermInfo.getArea(),intermInfo.getStaffNum());
		ArrayList<WarehouseInfo> poList=intermInfo.getWarehouseInfoList();
		for(WarehouseInfo po:poList){
			vo.addWarehouse(new WarehouseInfoVO(po.getCity(),po.getStaffNum()
					,po.getAcreage(),po.getArea(),po.getAlert()));
		}
		return vo;
		
		
	}
}
