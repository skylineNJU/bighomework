package main.businesslogic.financebl;

import java.util.ArrayList;

import main.businesslogicservice.FinanceBLService;
import main.vo.BankAccountVO;
import main.vo.CostVO;
import main.vo.DistanceVO;
import main.vo.EarnVO;
import main.vo.FeeVO;
import main.vo.SalaryVO;

public class FinanceController implements FinanceBLService {

	@Override
	public ArrayList<ArrayList> showStatisticsList(String date) {
		return new StatisticsList().showStatisticsList(date);
	}

	@Override
	public ArrayList<EarnVO> showEarnListDependsOnDay(String date){
		return new EarnList().readEarnList(date);
	}

	@Override
	public ArrayList<BankAccountVO> showBalance() {
		return new Balance().readBalance();
	}


	@Override
	public ArrayList<CostVO> showCostList(String date) {
		return new CostList().readCostList(date);
	}


	@Override
	public boolean writeEarn(EarnVO earnVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean writeCost(CostVO costVO) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public DistanceVO getDistance(){
		return new Distance().getDistance();
	}

	@Override
	public SalaryVO readSalary() {
		return new Salary().getSalary();
	}

	@Override
	public FeeVO readFee() {
		return new Fee().getFee();
	}

	@Override
	public ArrayList<EarnVO> showLobbyEarn(String date, String unit) {
		return new LobbyEarn().readLobbyEarn(date, unit);
	}
	
}
