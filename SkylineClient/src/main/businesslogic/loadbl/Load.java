package main.businesslogic.loadbl;

import main.data.load.LoadDataController;
import main.dataservice.LoadDataService;
import main.po.LoadingInfoPO;
import main.vo.LobbyLoading;

public class Load {
	private LoadingInfoPO po;
	
	public boolean loadVehicle(LobbyLoading vo){
		po=new LoadingInfoPO(
				vo.getLoadingDate(),
				vo.getAutoMobileNum(),
				vo.getDeparture(),
				vo.getDestination(),
				vo.getMonitor(),
				vo.getGuard(),
				vo.getShipment(),
				vo.getFreight()
				);
		po.setCode(vo.getCode());
		LoadDataService service=new LoadDataController();
		service.saveLobbyLoadingReceipt(po);
		return false;	
	}
}
