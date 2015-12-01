package main.businesslogic.loadbl;

import java.util.ArrayList;

import main.data.load.LoadDataController;
import main.dataservice.LoadDataService;
import main.po.TrainLoadListPO;
import main.po.TrainLoadingPO;
import main.vo.TrainLoadingVO;

public class TrainLoadListBL {
	private TrainLoadListPO poList;
	private String codeList;
	public TrainLoadListBL(String codeList){
		this.codeList=codeList;
	}
	
	public ArrayList<TrainLoadingVO> inquire(){
		System.out.println("inquire train");
		ArrayList<TrainLoadingVO> voList=new ArrayList<TrainLoadingVO>();
		LoadDataService service=new LoadDataController();
		poList=new TrainLoadListPO(codeList);
		poList=service.inquireTrainLoadList(poList);
		ArrayList<TrainLoadingPO> list=poList.getPoList();
		for(TrainLoadingPO po:list){
			TrainLoadingVO vo=new TrainLoadingVO(
					po.getCode(),
					po.getLoadingDate(),
					po.getTrainNum(),
					po.getTrainTourNum(),
					po.getDeparture(),
					po.getDestination(),
					po.getMonitor(),
					po.getStore(),
					po.getShipment(),
					po.getFreight());
			voList.add(vo);
		}
		return voList;
	}
}
