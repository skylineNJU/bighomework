package logicservice;

import java.util.ArrayList;

import vo.AccountVO;
import vo.CostVO;
import vo.EarnVO;

public interface FinanceBLService {
	//���뿪ʼ���ںͽ������ڣ���ʾ���и������ڵ������տ��Ϣ
	public ArrayList<EarnVO> showStatisticsList(String date1,String date2);
	
	//�������ڣ��鿴�������е��տ
	public ArrayList<EarnVO> showEarnListDependsOnDay(String date);
	
	//����Ӫҵ����ţ��鿴��Ӫҵ����ָ�������������е��տ
	public ArrayList<EarnVO> showEarnListDependsOnInstitution(String code,String date1,String data2);
	
	//�����˻���ţ���ʾ�˻����
	public AccountVO showBalance(String name);
	
	//��ʾ���µ�����֧����Ϣ
	public ArrayList<CostVO> showCostList();
	
	//��ʾָ���·ݵ�֧����Ϣ
	public ArrayList<CostVO> showCostList(String date);
	
	//��ת����ҵ��Ա��д�տ��Ϣ��ϵͳ��ʾ�տ
	public ArrayList<EarnVO> writeEarnList(ArrayList<EarnVO> earn);
}
