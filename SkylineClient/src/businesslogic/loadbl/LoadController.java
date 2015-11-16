package businesslogic.loadbl;

import businesslogicservice.LoadBLService;
import vo.TransVO;
import vo.VehicleLoadingVO;

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
