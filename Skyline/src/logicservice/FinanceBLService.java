package logicservice;

import java.util.ArrayList;

import vo.AccountVO;
import vo.CostVO;
import vo.EarnVO;

public interface FinanceBLService {
	//输入开始日期和结束日期，显示所有该日期内的所有收款单信息
	public ArrayList<EarnVO> showStatisticsList(String date1,String date2);
	
	//输入日期，查看当天所有的收款单
	public ArrayList<EarnVO> showEarnListDependsOnDay(String date);
	
	//输入营业厅编号，查看该营业厅在指定日期内中所有的收款单
	public ArrayList<EarnVO> showEarnListDependsOnInstitution(String code,String date1,String data2);
	
	//输入账户编号，显示账户余额
	public AccountVO showBalance(String name);
	
	//显示本月的所有支出信息
	public ArrayList<CostVO> showCostList();
	
	//显示指定月份的支出信息
	public ArrayList<CostVO> showCostList(String date);
	
	//中转中心业务员填写收款单信息，系统显示收款单
	public ArrayList<EarnVO> writeEarnList(ArrayList<EarnVO> earn);
}
