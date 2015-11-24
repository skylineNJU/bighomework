package main.businesslogic.infobl.mocktest;

import static org.junit.Assert.*;
import org.junit.Test;

import main.vo.DriverVO;
import main.vo.InstitutionVO;
import main.vo.VehicleVO;

public class InfoControllerTest {

	@Test
	public void testCreateNewInstitution() {
		InstitutionVO vo=new InstitutionVO("Ӫҵ��","�Ͼ�����ϼ��Ӫҵ��"
				,"�Ͼ�����ϼ��","1234567");
		MockInstitution mock=new MockInstitution(vo);
		assertEquals("�Ͼ�����ϼ��",mock.getPosition());
		assertEquals(true,mock.saveInfo());
	}

	@Test
	public void testDeleteStaff(){
		assertEquals(true,MockStaff.delete("141250029"));
	}
	
	@Test
	public void testInquireVehicle(){
		VehicleVO vehicleInfo=new VehicleVO(null, null, null, null, null, null);
		MockVehicle vehicle=new MockVehicle("141250029");
		vehicleInfo.writeVehicleInfo(vehicle);
		assertEquals("2014-01-01",vehicleInfo.getBoughtTime());
	}
	
	@Test
	public void testmodifyDriver(){
		DriverVO drInfo=new DriverVO(null, null, null, null, null, null, null, null);
		MockDriver driver=new MockDriver(drInfo);
		assertEquals(true,driver.modify());
	}
}
