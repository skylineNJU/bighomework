package main.businesslogic.financebl;

import java.util.ArrayList;

public class StatisticsList {
	
	public ArrayList<ArrayList> showStatisticsList(String date){
		ArrayList<ArrayList> list = new ArrayList<ArrayList>();
		list.add(new EarnList().readEarnList(date));
		list.add(new CostList().readCostList(date));
		return list;
	}
}
