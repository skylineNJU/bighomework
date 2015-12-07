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
	
	//�������ڣ��鿴�������е��տ
	public ArrayList<EarnVO> showEarnListDependsOnDay(String date);
	
	//�����˻���ţ���ʾ�˻����
	public ArrayList<BankAccountVO> showBalance();
	
	//��ʾָ���·ݵ�֧����Ϣ
	public ArrayList<CostVO> showCostList(String date);
	
	//��д�տ��Ϣ��ϵͳ��ʾ�տ
	public boolean writeEarn(EarnVO earnVO);
	
	public boolean writeCost(CostVO costVO);
	
	public boolean writeSalary(SalaryVO salaryVO);
	
	public boolean writeFee(FeeVO feeVO);
	
	public boolean writeDistance(DistanceVO distanceVO);
	
	public boolean modifyDistance(DistanceVO distanceVO);
	
	public boolean delDistance(DistanceVO distanceVO);
	
	public boolean modifyBalance(BankAccountVO bankVO);
}
