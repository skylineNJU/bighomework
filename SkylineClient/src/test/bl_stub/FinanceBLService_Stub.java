package bl_stub;

import java.util.ArrayList;

import businesslogicservice.FinanceBLService;
import vo.AccountVO;
import vo.CostVO;
import vo.EarnVO;

public class FinanceBLService_Stub implements FinanceBLService{
	ArrayList<EarnVO> earn=new ArrayList<EarnVO>();
	AccountVO account;
	ArrayList<CostVO> cost=new ArrayList<CostVO>();
	@Override
	public ArrayList<EarnVO> showStatisticsList(String date1, String date2) {
		// TODO Auto-generated method stub
		earn.clear();
		EarnVO ea=new EarnVO("141250029",date1,"1234567890");
		EarnVO eaa=new EarnVO("141250029",date2,"1234567891");
		earn.add(ea);
		earn.add(eaa);
		return earn;
	}

	@Override
	public ArrayList<EarnVO> showEarnListDependsOnDay(String date) {
		// TODO Auto-generated method stub
		earn.clear();
		EarnVO ea=new EarnVO("141250029",date,"123456789021");
		EarnVO eaa=new EarnVO("141250029",date,"123456789121");
		earn.add(ea);
		earn.add(eaa);
		return earn;
	}

	@Override
	public ArrayList<EarnVO> showEarnListDependsOnInstitution(String code, String date1, String data2) {
		// TODO Auto-generated method stub
		earn.clear();
		EarnVO ea=new EarnVO("123456789121",date1,code);
		earn.add(ea);
		return null;
	}

	@Override
	public AccountVO showBalance(String name) {
		// TODO Auto-generated method stub
		account=new AccountVO(name,100000.0);
		return account;
	}

	@Override
	public ArrayList<CostVO> showCostList() {
		// TODO Auto-generated method stub
		CostVO co=new CostVO("1235123512","2014/1/1","123456789211","24212341234132", 0, null, null);
		cost.clear();
		cost.add(co);
		return cost;
	}

	@Override
	public ArrayList<CostVO> showCostList(String date) {
		// TODO Auto-generated method stub
		CostVO co=new CostVO("1235123512",date,"123456789211","24212341234132", 0, null, null);
		cost.clear();
		cost.add(co);
		return cost;
	}

	@Override
	public ArrayList<EarnVO> writeEarnList(ArrayList<EarnVO> earn) {
		// TODO Auto-generated method stub
		return earn;
	}

}
