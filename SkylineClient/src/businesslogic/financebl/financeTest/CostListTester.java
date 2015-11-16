package businesslogic.financebl.financeTest;

import java.util.ArrayList;

import vo.CostType;
import vo.CostVO;

public class CostListTester {
	
	CostVO costVO = new CostVO("3153", "2015/03/15", "65165", "刘钦", 20.6, "好人一生平安", CostType.reward);
	
	public boolean readCostList(ArrayList<CostVO> costList) {
		costList.set(0, costVO);
		return true;
	}
	public boolean readCostList(String date, ArrayList<CostVO> costList) {
		costList.set(0, costVO);
		return true;
	}
	public boolean readCostList(String date1,String date2,ArrayList<CostVO> costList) { 
		costList.set(0, costVO);
		return true;
	}
	public boolean writeCostList(ArrayList<CostVO> costList) {
		System.out.println("write succeed!");
		return true;
	}
}

