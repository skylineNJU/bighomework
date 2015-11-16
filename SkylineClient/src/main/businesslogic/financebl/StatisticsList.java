package main.businesslogic.financebl;

import java.util.ArrayList;

import main.vo.CostVO;
import main.vo.EarnVO;

public class StatisticsList {
	
	public boolean showStatisticsList(String date1, String date2,
			ArrayList<EarnVO> earnList,ArrayList<CostVO> costList){
		CostList costArrayList = new CostList();
		EarnList earnArrayList = new EarnList();
		earnArrayList.readEarnList(date1, date2, earnList);
		costArrayList.readCostList(date1, date2, costList);
		return true;
	}
}
