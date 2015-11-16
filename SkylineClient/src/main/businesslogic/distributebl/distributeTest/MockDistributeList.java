package main.businesslogic.distributebl.distributeTest;

import java.util.ArrayList;

import main.businesslogic.distributebl.DistributeList;
import main.vo.DistributeVO;

public class MockDistributeList extends DistributeList{
	
	public boolean writeDistribute(ArrayList<DistributeVO> distributeList){
		
		return true;
	} 
}
