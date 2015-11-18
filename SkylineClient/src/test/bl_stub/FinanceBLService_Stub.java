package test.bl_stub;

import java.util.ArrayList;

import main.businesslogicservice.FinanceBLService;
import main.vo.BankAccountVO;
import main.vo.CostVO;
import main.vo.EarnVO;

public class FinanceBLService_Stub implements FinanceBLService{
	ArrayList<EarnVO> earn=new ArrayList<EarnVO>();
	BankAccountVO account;
	ArrayList<CostVO> cost=new ArrayList<CostVO>();
	@Override
	public boolean showStatisticsList(String date1, String date2,ArrayList<EarnVO> earnList,ArrayList<CostVO> costList) {
		earn.clear();
		EarnVO ea=new EarnVO("141250029",date1,"1234567890");
		EarnVO eaa=new EarnVO("141250029",date2,"1234567891");
		earn.add(ea);
		earn.add(eaa);
		return true;
	}

	@Override
	public boolean showEarnListDependsOnDay(String date,ArrayList<EarnVO> earnList) {
		// TODO Auto-generated method stub
		earn.clear();
		EarnVO ea=new EarnVO("141250029",date,"123456789021");
		EarnVO eaa=new EarnVO("141250029",date,"123456789121");
		earn.add(ea);
		earn.add(eaa);
		return true;
	}

	@Override
	public boolean showEarnListDependsOnInstitution(String code, String date1, String data2,ArrayList<EarnVO> earnList) {
		// TODO Auto-generated method stub
		earn.clear();
		EarnVO ea=new EarnVO("123456789121",date1,code);
		earn.add(ea);
		return true;
	}

	@Override
	public boolean showBalance(String name,BankAccountVO account) {
		// TODO Auto-generated method stub
		account=new BankAccountVO(name,100000.0);
		return true;
	}

	@Override
	public boolean showCostList(ArrayList<CostVO> costList) {
		// TODO Auto-generated method stub
		CostVO co=new CostVO("1235123512","2014/1/1","123456789211","24212341234132", 0, null, null);
		cost.clear();
		cost.add(co);
		return true;
	}

	@Override
	public boolean showCostList(String date,ArrayList<CostVO> costList) {
		// TODO Auto-generated method stub
		CostVO co=new CostVO("1235123512",date,"123456789211","24212341234132", 0, null, null);
		cost.clear();
		cost.add(co);
		return true;
	}

	@Override
	public boolean writeEarnList(ArrayList<EarnVO> earn) {
		
		return true;
	}

	@Override
	public boolean writeCostList(ArrayList<CostVO> costList) {
		
		return false;
	}

}
