package businesslogic.loadbl;

import businesslogicservice.LoadBLService;
import vo.TransType;
import vo.TransVO;
import vo.VehicleLoadingVO;

public class LoadController implements LoadBLService {

	@Override
	public VehicleLoadingVO loadVehicle(String id, String date, String vehiclecode, String from, String to,
			String monitor, String escort, String[] ordercode, double fee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransVO intermidateLoading(String id, TransType type, String Transcode, String Vehiclecode, String from,
			String to, String compartment, String monitor, String[] ordercode) {
		// TODO Auto-generated method stub
		return null;
	}

}
