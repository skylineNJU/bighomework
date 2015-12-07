package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.BankAccountVO;
import main.vo.CostVO;
import main.vo.DistanceVO;
import main.vo.EarnVO;
import main.vo.FeeVO;
import main.vo.SalaryVO;

public interface FinanceBLService {
	
	public boolean delSalary(SalaryVO salaryVO);
	
	public boolean modifySalary(SalaryVO salaryVO);
	
	public boolean delFee(FeeVO feeVO);
	
	public boolean modifyFee(FeeVO feeVO);
	
	public boolean delCollection(EarnVO earnVO);
	
	public boolean modifyCollection(EarnVO earnVO);
	
	public boolean modifyCost(CostVO costVO);
	
	public boolean deleteCost(CostVO costVO);
	
	public DistanceVO getDistance();
	
	public ArrayList<ArrayList> showStatisticsList(String date);
	
	public ArrayList<EarnVO> showLobbyEarn(String date,String unit);
	
	public SalaryVO readSalary();
	
	public FeeVO readFee();
	
	//输入日期，查看当天所有的收款单
	public ArrayList<EarnVO> showEarnListDependsOnDay(String date);
	
	//输入账户编号，显示账户余额
	public ArrayList<BankAccountVO> showBalance();
	
	//显示指定月份的支出信息
	public ArrayList<CostVO> showCostList(String date);
	
	//填写收款单信息，系统显示收款单
	public boolean writeEarn(EarnVO earnVO);
	
	public boolean writeCost(CostVO costVO);
	
	public boolean writeSalary(SalaryVO salaryVO);
	
	public boolean writeFee(FeeVO feeVO);
	
	public boolean writeDistance(DistanceVO distanceVO);
	
	public boolean modifyDistance(DistanceVO distanceVO);
	
	public boolean delDistance(DistanceVO distanceVO);
	
	public boolean modifyBalance(BankAccountVO bankVO);
}
