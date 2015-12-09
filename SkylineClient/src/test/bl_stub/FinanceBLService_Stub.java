package test.bl_stub;

import java.util.ArrayList;

import main.businesslogicservice.FinanceBLService;
import main.vo.BankAccountVO;
import main.vo.CostVO;
import main.vo.DistanceVO;
import main.vo.EarnVO;
import main.vo.FeeVO;
import main.vo.SalaryVO;



public class FinanceBLService_Stub implements FinanceBLService{
	ArrayList<EarnVO> earn=new ArrayList<EarnVO>();
	BankAccountVO account;
	ArrayList<CostVO> cost=new ArrayList<CostVO>();
	ArrayList<ArrayList>array=new ArrayList<ArrayList>();
	ArrayList<BankAccountVO>bankAccount=new ArrayList<BankAccountVO>();
	String date="20150201";
	@Override
	public ArrayList<ArrayList> showStatisticsList(String date) {
		array.clear();
		EarnVO ea=new EarnVO("141250029",date,"1234567890","77777",9.9,"1","1");
		
		return array;
	}

	@Override
	public ArrayList<EarnVO> showEarnListDependsOnDay(String date) {
		// TODO Auto-generated method stub
		earn.clear();
		EarnVO ea=new EarnVO("141250029",date,"1234567890","77777",9.9,"1","1");
		earn.add(ea);
		return earn;
	}


	@Override
	public ArrayList<BankAccountVO> showBalance() {
		// TODO Auto-generated method stub
		account=new BankAccountVO("12345",100000.0);
		bankAccount.add(account);
		return bankAccount;
	}

	@Override
	public ArrayList<CostVO> showCostList(String date) {
		// TODO Auto-generated method stub
		CostVO co=new CostVO("1235123512","2014/1/1","123456789211",1.1,"24212341234132", "", "");
		cost.clear();
		cost.add(co);
		return cost;
	}



	@Override
	public boolean writeEarn(EarnVO earnVO) {
		
		return true;
	}

	@Override
	public boolean writeCost(CostVO costVO) {
		
		return false;
	}

	@Override
	public boolean delSalary(SalaryVO salaryVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifySalary(SalaryVO salaryVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delFee(FeeVO feeVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFee(FeeVO feeVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delCollection(EarnVO earnVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyCollection(EarnVO earnVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyCost(CostVO costVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCost(CostVO costVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DistanceVO getDistance() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<EarnVO> showLobbyEarn(String date, String unit) {
		// TODO Auto-generated method stub
		EarnVO ea=new EarnVO("141250029",date,"1234567890","77777",9.9,"1","1");
		earn.add(ea);
		return earn;
	}

	@Override
	public SalaryVO readSalary() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public FeeVO readFee() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean writeSalary(SalaryVO salaryVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean writeFee(FeeVO feeVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean writeDistance(DistanceVO distanceVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean modifyDistance(DistanceVO distanceVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delDistance(DistanceVO distanceVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean modifyBalance(BankAccountVO bankVO) {
		// TODO Auto-generated method stub
		return true;
	}

}
