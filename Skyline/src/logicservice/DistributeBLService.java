package logicservice;

import java.util.ArrayList;

import vo.DistributeVO;
import vo.RecipientVO;

public interface DistributeBLService {
	//��ʾ�ɼ����б�
	public ArrayList<DistributeVO> showDistributeList();
	
	//�ռ�������д�ռ����룬�ռ����������ռ����ڣ�ϵͳ��ʾ��д����Ϣ
	public RecipientVO writeReceiveMessage(String code,String name,String date);
}
