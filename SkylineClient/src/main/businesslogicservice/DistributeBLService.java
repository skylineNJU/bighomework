package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.DistributeVO;
import main.vo.RecipientVO;

public interface DistributeBLService {
	//��ʾ�ɼ����б�
	public ArrayList<DistributeVO> showDistributeList(String courierCode);
	
	public boolean writeDistributeList(ArrayList<DistributeVO> voList);
	
	//�ռ�������д�ռ����룬�ռ����������ռ����ڣ�ϵͳ��ʾ��д����Ϣ
	public boolean writeReceiveMessage(RecipientVO recipient);
}
