package main.businesslogic.financebl.financeTest;

import java.util.ArrayList;

import main.businesslogic.financebl.StatisticsList;
import main.vo.CostVO;
import main.vo.EarnVO;

public class MockStatisticsList extends StatisticsList {
	
	public boolean showStatisticsList(String date1, String date2,
			ArrayList<EarnVO> earnList,ArrayList<CostVO> costList){
		MockEarnList earn = new MockEarnList();
		MockCostList cost = new MockCostList();
		earn.readEarnList(date1, date2, earnList);
		cost.readCostList(date1, date2, costList);
		return true;
	}
}
