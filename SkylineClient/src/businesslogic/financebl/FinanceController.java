package businesslogic.financebl;

import java.util.ArrayList;

import businesslogicservice.FinanceBLService;
import vo.AccountVO;
import vo.CostVO;
import vo.EarnVO;

public class FinanceController implements FinanceBLService {

	@Override
	public boolean showStatisticsList(String date1, String date2,
			ArrayList<EarnVO> earnList,ArrayList<CostVO> costList) {
		CostList costArrayList = new CostList();
		EarnList earnArrayList = new EarnList();
		earnArrayList.readEarnList(date1, date2, earnList);
		costArrayList.readCostList(date1, date2, costList);
		return false;
	}

	@Override
	public boolean showEarnListDependsOnDay(String date,
			ArrayList<EarnVO> earnList) {
		EarnList earnArrayList = new EarnList();
		earnArrayList.readEarnList(date, earnList);
		return false;
	}

	@Override
	public boolean showEarnListDependsOnInstitution(String code, String date1,
			String data2, ArrayList<EarnVO> earnList) {
		EarnList earnArrayList = new EarnList();
		earnArrayList.readEarnList(code, date1, data2, earnList);
		return false;
	}

	@Override
	public boolean showBalance(String name, AccountVO account) {
		Balance balance = new Balance();
		balance.readBalance(name, account);
		return false;
	}

	@Override
	public boolean showCostList(ArrayList<CostVO> costList) {
		CostList costArrayList = new CostList();
		costArrayList.readCostList(costList);
		return false;
	}

	@Override
	public boolean showCostList(String date, ArrayList<CostVO> costList) {
		CostList costArrayList = new CostList();
		costArrayList.readCostList(date, costList);
		return false;
	}

	@Override
	public boolean writeEarnList(ArrayList<EarnVO> earnList) {
		EarnList earnArrayList = new EarnList();
		earnArrayList.writeEarn(earnList);
		return false;
	}

	@Override
	public boolean writeCostList(ArrayList<CostVO> costList) {
		CostList costArrayList = new CostList();
		costArrayList.writeCostList(costList);
		return false;
	}
	
}
