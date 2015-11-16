package businesslogic.infobl.mocktest;

import businesslogic.infobl.Staff;
import vo.StaffVO;

public class MockStaff extends Staff{

	public MockStaff(StaffVO vo) {
		super(vo);
		// TODO Auto-generated constructor stub
	}

	public MockStaff(String staffCode){
		super(staffCode);
	}
	
	
}
