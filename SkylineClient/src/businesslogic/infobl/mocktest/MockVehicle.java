package businesslogic.infobl.mocktest;

import businesslogic.infobl.Vehicle;
import vo.VehicleVO;

public class MockVehicle extends Vehicle {

	public MockVehicle(VehicleVO vo) {
		super(vo);
		// TODO Auto-generated constructor stub
	}

	public MockVehicle(String vehicleCode) {
		super(vehicleCode);
		// TODO Auto-generated constructor stub
		super.setBoughtTime("2014-01-01");
		super.setCarID(12344321);
		super.setCarNum(001);
		super.setEngineID(43211234);
		super.setUnderpanID(2121212);
		super.setUsedTime(1);
	}

	
}
