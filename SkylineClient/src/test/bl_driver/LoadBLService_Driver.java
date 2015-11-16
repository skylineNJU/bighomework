package bl_driver;

import vo.TransType;
import vo.TransVO;
import vo.VehicleLoadingVO;
import businesslogicservice.LoadBLService;

public class LoadBLService_Driver {
	public void drive(LoadBLService LoadBLService){
		String[] code = new String[]{ "120100101","1222122"};
		VehicleLoadingVO vehicleLoading =LoadBLService.loadVehicle("12112718111", "20090101", "1919191", "nanjing", "shangahai", "1", "2",code, 200.2);
		if(vehicleLoading != null){
			System.out.println("---------Loading Success!-------------");
		}
		
		TransVO trans =LoadBLService.intermidateLoading("10101", TransType.plane, "1102010", "2010101010", "nanjing", "shanghai", "2", "2", code);
		if(trans!= null){
			System.out.println("---------IntermidateLoading Success!-------------");
		}
	
	
	
	}
}
