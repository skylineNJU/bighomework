package main.businesslogic.loadbl;

import main.businesslogicservice.LoadBLService;
import main.vo.TransVO;
import main.vo.VehicleLoadingVO;

public class LoadController implements LoadBLService {

	@Override
	public boolean loadVehicle(VehicleLoadingVO vehicleLoadingInfo) {
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
