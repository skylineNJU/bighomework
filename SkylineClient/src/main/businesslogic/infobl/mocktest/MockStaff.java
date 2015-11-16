package main.businesslogic.infobl.mocktest;

import main.businesslogic.infobl.Staff;
import main.vo.StaffVO;

public class MockStaff extends Staff{

	public MockStaff(StaffVO vo) {
		super(vo);
		// TODO Auto-generated constructor stub
	}

	public MockStaff(String staffCode){
		super(staffCode);
	}
	
	
}
