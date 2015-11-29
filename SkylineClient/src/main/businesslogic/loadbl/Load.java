package main.businesslogic.loadbl;

import main.vo.LobbyLoading;
import main.vo.TransVO;
import main.vo.VehicleLoadingVO;

public class Load {
	public boolean loadVehicle(LobbyLoading vehicleLoadingInfo){
		System.out.println("bagin to loading");
		Loading loa=new Loading(vehicleLoadingInfo);
		loa.saveInfo();
		return true;
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
