package businesslogic.distributebl.distributeTest;

import java.util.ArrayList;

import businesslogic.distributebl.DistributeList;
import vo.DistributeVO;

public class MockDistributeList extends DistributeList{
	
	public boolean writeDistribute(ArrayList<DistributeVO> distributeList){
		
		return true;
	} 
}
