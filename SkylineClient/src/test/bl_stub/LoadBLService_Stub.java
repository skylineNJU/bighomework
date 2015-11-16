package bl_stub;

import businesslogicservice.LoadBLService;
import vo.TransType;
import vo.TransVO;
import vo.VehicleLoadingVO;

public class LoadBLService_Stub implements LoadBLService{
	VehicleLoadingVO vehl;
	TransVO trans;
    @Override
	public VehicleLoadingVO loadVehicle(String id, String date, String vehiclecode, String from, String to,
			String monitor, String escort, String[] ordercode, double fee) {
		// TODO Auto-generated method stub
    	vehl=new VehicleLoadingVO(id,date,"null",vehiclecode,from,to,monitor,escort,ordercode,fee);
		return vehl;
	}

	@Override
	public TransVO intermidateLoading(String id, TransType type, String Transcode, String Vehiclecode, String from,
			String to, String compartment, String monitor, String[] ordercode) {
		// TODO Auto-generated method stub
		trans=new TransVO(id,"null","null",type,Transcode,Vehiclecode,from,
				to,compartment,monitor,ordercode);
		return trans;
	}
	
}
