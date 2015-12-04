package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.BankAccountVO;
import main.vo.CostVO;
import main.vo.EarnVO;

public interface FinanceBLService {
	
	public ArrayList<ArrayList> showStatisticsList(String date);
	
	//输入日期，查看当天所有的收款单
	public ArrayList<EarnVO> showEarnListDependsOnDay(String date);
	
	//输入账户编号，显示账户余额
	public ArrayList<BankAccountVO> showBalance();
	
	//显示指定月份的支出信息
	public ArrayList<CostVO> showCostList(String date);
	
	//填写收款单信息，系统显示收款单
	public boolean writeEarn(EarnVO earnVO);
	
	public boolean writeCost(CostVO costVO);
}
