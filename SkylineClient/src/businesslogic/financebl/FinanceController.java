package businesslogic.financebl;

import java.util.ArrayList;

import businesslogicservice.FinanceBLService;
import vo.AccountVO;
import vo.CostVO;
import vo.EarnVO;

public class FinanceController implements FinanceBLService {

	@Override
	public ArrayList<EarnVO> showStatisticsList(String date1, String date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EarnVO> showEarnListDependsOnDay(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EarnVO> showEarnListDependsOnInstitution(String code, String date1, String data2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountVO showBalance(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CostVO> showCostList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CostVO> showCostList(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EarnVO> writeEarnList(ArrayList<EarnVO> earn) {
		// TODO Auto-generated method stub
		return null;
	}

}
