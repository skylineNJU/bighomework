package main.businesslogic.loadbl;

import main.businesslogicservice.LoadBLService;
import main.vo.LobbyLoading;
import main.vo.TransVO;

public class LoadController implements LoadBLService {

	@Override
	public boolean loadVehicle(LobbyLoading vehicleLoadingInfo) {
		// TODO Auto-generated method stub
		Load load=new Load();
		return load.loadVehicle(vehicleLoadingInfo);
	}

	@Override
	public boolean intermidateLoading(TransVO transInfo) {
		// TODO Auto-generated method stub
		Load load=new Load();
		return load.intermidateLoading(transInfo);
	}

	

}
