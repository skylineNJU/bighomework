package main.businesslogic.financebl;

import java.util.ArrayList;

import main.businesslogicservice.FinanceBLService;
import main.po.CollectionPO;
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
		return new EarnList().writeEarn(earnVO);
	}

	@Override
	public boolean writeCost(CostVO costVO) {
		return new CostList().writeCostList(costVO);
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

	@Override
	public boolean writeSalary(SalaryVO salaryVO) {
		return new Salary().writeSalary(salaryVO);
	}

	@Override
	public boolean writeFee(FeeVO feeVO) {
		return new Fee().writeFee(feeVO);
	}

	@Override
	public boolean writeDistance(DistanceVO distanceVO) {
		return new Distance().writeDistance(distanceVO);
	}

	@Override
	public boolean modifyBalance(BankAccountVO bankVO) {
		return new Balance().changeBalance(bankVO);
	}

	@Override
	public boolean deleteCost(CostVO costVO) {
		return new CostList().deleteCost(costVO);
	}

	@Override
	public boolean modifyCost(CostVO costVO) {
		deleteCost(costVO);
		return writeCost(costVO);
	}

	@Override
	public boolean delDistance(DistanceVO distanceVO) {
		return new Distance().delDistance(distanceVO);
	}

	@Override
	public boolean modifyDistance(DistanceVO distanceVO) {
		delDistance(distanceVO);
		return writeDistance(distanceVO);
	}

	@Override
	public boolean delCollection(EarnVO earnVO) {
		return new EarnList().delEarn(earnVO);
	}

	@Override
	public boolean modifyCollection(EarnVO earnVO) {
		delCollection(earnVO);
		return writeEarn(earnVO);
	}

	@Override
	public boolean delFee(FeeVO feeVO) {
		return new Fee().delFee(feeVO);
	}

	@Override
	public boolean modifyFee(FeeVO feeVO) {
		delFee(feeVO);
		return writeFee(feeVO);
	}

	@Override
	public boolean delSalary(SalaryVO salaryVO) {
		return new Salary().delSalary(salaryVO);
	}

	@Override
	public boolean modifySalary(SalaryVO salaryVO) {
		delSalary(salaryVO);//好像有问题，哦，我知道了，因为我没有删除，需要在数据库里加一项作为索引删除
		writeSalary(salaryVO);
		return false;
	}
	
}
