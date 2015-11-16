package main.businesslogic.loadbl.mocktest;

import static org.junit.Assert.*;

import org.junit.Test;

import main.vo.TransVO;
import main.vo.VehicleLoadingVO;

public class LoadControllerTest {

	@Test
	public void testLoadVehicle() {
		MockLoad load=new MockLoad();
		VehicleLoadingVO vehicleLoadingInfo=new VehicleLoadingVO("1234234", null, 
				null, null,
				null, null,
				null, null, 
				null, 0
				);
		assertEquals(true,load.loadVehicle(vehicleLoadingInfo));
	}
	
	@Test
	public void testIntermidateLoading(){
		MockLoad load=new MockLoad();
		TransVO transInfo=new TransVO(null, null, null, null, null,
				null, null, null, null, null, null);
		assertEquals(true,load.intermidateLoading(transInfo));
	}

}
