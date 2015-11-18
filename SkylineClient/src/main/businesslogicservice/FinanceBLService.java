package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.BankAccountVO;
import main.vo.CostVO;
import main.vo.EarnVO;

public interface FinanceBLService {
	//���뿪ʼ���ںͽ������ڣ���ʾ���и������ڵ������տ��Ϣ
	public boolean showStatisticsList(String date1,String date2,ArrayList<EarnVO> earnList,ArrayList<CostVO> costList);
	
	//�������ڣ��鿴�������е��տ
	public boolean showEarnListDependsOnDay(String date,ArrayList<EarnVO> earnList);
	
	//����Ӫҵ����ţ��鿴��Ӫҵ����ָ�������������е��տ
	public boolean showEarnListDependsOnInstitution(String code,String date1,String data2,ArrayList<EarnVO> earnList);
	
	//�����˻���ţ���ʾ�˻����
	public boolean showBalance(String name,BankAccountVO account);
	
	//��ʾ���µ�����֧����Ϣ
	public boolean showCostList(ArrayList<CostVO> costList);
	
	//��ʾָ���·ݵ�֧����Ϣ
	public boolean showCostList(String date,ArrayList<CostVO> costList);
	
	//��д�տ��Ϣ��ϵͳ��ʾ�տ
	public boolean writeEarnList(ArrayList<EarnVO> earnList);
	
	public boolean writeCostList(ArrayList<CostVO> costList);
}
