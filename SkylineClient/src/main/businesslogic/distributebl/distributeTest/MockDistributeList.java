package main.businesslogic.distributebl.distributeTest;

import java.util.ArrayList;

import main.businesslogic.distributebl.DistributeList;
import main.vo.DistributeVO;

public class MockDistributeList extends DistributeList{
	
	public boolean writeDistribute(ArrayList<DistributeVO> distributeList){
		DistributeVO distributeVO = new DistributeVO("123456", "ÁõÇÕ", "ÄÏ¾©", "12345678", "12356", null);
		distributeList.add(distributeVO);
		return true;
	} 
}
