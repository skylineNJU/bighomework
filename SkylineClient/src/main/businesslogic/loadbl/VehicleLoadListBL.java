package main.businesslogic.loadbl;

import java.util.ArrayList;

import main.data.load.LoadDataController;
import main.dataservice.LoadDataService;
import main.po.VehicleLoadListPO;
import main.po.VehicleLoadingPO;
import main.vo.VehicleLoadingVO;

public class VehicleLoadListBL {
	private VehicleLoadListPO poList;
	
	public VehicleLoadListBL(String codeList){
		poList=new VehicleLoadListPO(codeList);
	}
	
	public ArrayList<VehicleLoadingVO> inquire(){
		System.out.println("inquire vehicle");
		ArrayList<VehicleLoadingVO> voList=new ArrayList<VehicleLoadingVO>();
		LoadDataService service=new LoadDataController();
		poList=service.inquireVehicleLoadList(poList);
		ArrayList<VehicleLoadingPO> list=poList.getLoadList();
		for(VehicleLoadingPO po:list){
			VehicleLoadingVO vo=new VehicleLoadingVO(
					po.getCode(),
					po.getLoadingDate(),
					po.getCarNum(),
					po.getCarTourNum(),
					po.getDeparture(),
					po.getDestination(),
					po.getMonitor(),
					po.getGuard(),
					po.getShipment(),
					po.getFreight());
			voList.add(vo);
		}
		return voList;
	}
}
