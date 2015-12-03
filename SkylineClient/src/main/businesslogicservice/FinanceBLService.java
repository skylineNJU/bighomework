package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.BankAccountVO;
import main.vo.CostVO;
import main.vo.EarnVO;

public interface FinanceBLService {
	
	public ArrayList<ArrayList> showStatisticsList(String date);
	
	//�������ڣ��鿴�������е��տ
	public ArrayList<EarnVO> showEarnListDependsOnDay(String date);
	
	//�����˻���ţ���ʾ�˻����
	public ArrayList<BankAccountVO> showBalance();
	
	//��ʾָ���·ݵ�֧����Ϣ
	public ArrayList<CostVO> showCostList(String date);
	
	//��д�տ��Ϣ��ϵͳ��ʾ�տ
	public boolean writeEarn(EarnVO earnVO);
	
	public boolean writeCost(CostVO costVO);
}
