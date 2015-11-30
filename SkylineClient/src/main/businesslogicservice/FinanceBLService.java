package main.businesslogicservice;

import java.util.ArrayList;

import main.po.BankList;
import main.vo.BankAccountVO;
import main.vo.CostVO;
import main.vo.EarnVO;

public interface FinanceBLService {
	//输入开始日期和结束日期，显示所有该日期内的所有收款单信息
	public boolean showStatisticsList(String date1,String date2,ArrayList<EarnVO> earnList,ArrayList<CostVO> costList);
	
	//输入日期，查看当天所有的收款单
	public boolean showEarnListDependsOnDay(String date,ArrayList<EarnVO> earnList);
	
	//输入营业厅编号，查看该营业厅在指定日期内中所有的收款单
	public boolean showEarnListDependsOnInstitution(String code,String date1,String data2,ArrayList<EarnVO> earnList);
	
	//输入账户编号，显示账户余额
	public ArrayList<BankAccountVO> showBalance();
	
	//显示本月的所有支出信息
	public boolean showCostList(ArrayList<CostVO> costList);
	
	//显示指定月份的支出信息
	public boolean showCostList(String date,ArrayList<CostVO> costList);
	
	//填写收款单信息，系统显示收款单
	public boolean writeEarnList(ArrayList<EarnVO> earnList);
	
	public boolean writeCostList(ArrayList<CostVO> costList);
}
