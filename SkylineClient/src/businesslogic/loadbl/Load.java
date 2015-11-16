package businesslogic.loadbl;

import vo.TransVO;
import vo.VehicleLoadingVO;

public class Load {
	public boolean loadVehicle(VehicleLoadingVO vehicleLoadingInfo){
		Loading loa=new Loading(vehicleLoadingInfo);
		return loa.saveLoading();
	}
	
	public boolean intermidateLoading(TransVO transInfo){
		switch(transInfo.getTransType()){
		case BUS:
			VehicleLoading vehicle=new VehicleLoading(transInfo);
			vehicle.saveLoading();
			break;
		case TRAIN:
			TrainLoading train=new TrainLoading(transInfo);
			train.saveLoading();
			break;
		case PLANE:
			PlaneLoading plane=new PlaneLoading(transInfo);
			plane.saveLoading();
			break;
		}
		return true;
	}
}
