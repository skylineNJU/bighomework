package businesslogic.financebl.financeTest;

import java.util.ArrayList;

import vo.AccountVO;
import vo.CostType;
import vo.CostVO;
import vo.EarnVO;
import businesslogic.financebl.Balance;
import businesslogic.financebl.CostList;
import businesslogic.financebl.EarnList;
import businesslogic.financebl.FinanceController;

public class MockFinance extends FinanceController{

	EarnVO earnVO = new EarnVO("253156", "2015/03/15", "15168168");
	CostVO costVO = new CostVO("3153", "2015/03/15", "65165", "刘钦", 20.6, "好人一生平安", CostType.reward);
	String name = "50163046831";
	AccountVO accountVO = new AccountVO(this.name, 20122.2);
	
	public boolean showStatisticsList(String date1, String date2,
			ArrayList<EarnVO> earnList,ArrayList<CostVO> costList) {
		earnList.set(0, earnVO);
		costList.set(0, costVO);
		return false;
	}

	public boolean showEarnListDependsOnDay(String date,ArrayList<EarnVO> earnList) {
		earnList.set(0, earnVO);
		return false;
	}

	public boolean showEarnListDependsOnInstitution(String code, String date1,
			String data2, ArrayList<EarnVO> earnList) {
		earnList.set(0, earnVO);
		return false;
	}

	public boolean showBalance(String name, AccountVO account) {
		account = accountVO;
		return false;
	}

	public boolean showCostList(ArrayList<CostVO> costList) {
		costList.set(0, costVO);
		return false;
	}

	public boolean showCostList(String date, ArrayList<CostVO> costList) {
		costList.set(0, costVO);
		return false;
	}

	public boolean writeEarnList(ArrayList<EarnVO> earnList) {
		earnList.set(0, earnVO);
		return false;
	}

	public boolean writeCostList(ArrayList<CostVO> costList) {
		costList.set(0, costVO);
		return false;
	}
}
