package businesslogic.infobl.mocktest;

import businesslogic.infobl.Institution;
import vo.InstitutionVO;

public class MockInstitution extends Institution{

	public MockInstitution(InstitutionVO vo) {
		super(vo);
		// TODO Auto-generated constructor stub
	}
	
	public MockInstitution(String institutionCode){
		super(institutionCode);
	}
	
	
}
