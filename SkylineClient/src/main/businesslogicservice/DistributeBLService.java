package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.DistributeVO;
import main.vo.RecipientVO;

public interface DistributeBLService {
	//��ʾ�ɼ����б�
	public boolean showDistributeList(ArrayList<DistributeVO> distributeList);
	
	//�ռ�������д�ռ����룬�ռ����������ռ����ڣ�ϵͳ��ʾ��д����Ϣ
	public boolean writeReceiveMessage(RecipientVO recipient);
}
