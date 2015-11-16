package main.businesslogic.infobl.mocktest;

import main.businesslogic.infobl.Institution;
import main.vo.InstitutionVO;

public class MockInstitution extends Institution{

	public MockInstitution(InstitutionVO vo) {
		super(vo);
		// TODO Auto-generated constructor stub
	}
	
	public MockInstitution(String institutionCode){
		super(institutionCode);
	}
	
	
}
