package businesslogic.distributebl.distributeTest;

import java.util.ArrayList;
import vo.DistributeVO;

public class DistributeListTester {
	
	DistributeVO distributeVO = new DistributeVO("123456", "ÁõÇÕ", "ÄÏ¾©", "12345678", "12356");
	
	public boolean writeDistribute(ArrayList<DistributeVO> distributeList){
		distributeList.set(0, distributeVO);
		return true;
	} 
}
