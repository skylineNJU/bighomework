package dataservice;

import State.RightType;

//Ȩ�޹������ݽӿ�
public interface RightDataService {

	//�����ʼ��
	//�����˻��������ݿ��е��˻���������Ϊ��ʼֵ
	public void initKeyWord(String account);
	
	//ɾ���˻�
	//�����˻��������ݿ��е��˻�ɾ��
	public void delAccount(String account);
	
	//����Ȩ��
	//Ȩ��Ӧ������Ϊö������
	//rightTypeΪ��Ҫ���ӵ�Ȩ��
	public void addRight(RightType rightType);
	
	//ɾ��Ȩ��
	//Ȩ��Ӧ������Ϊö������
	//rightTypeΪ��Ҫ���ӵ�Ȩ��
	public void delRight(RightType rightType);
	
	//�����ݿ��ж�ȡ���˻���Ȩ��
	public RightType readRight(String accpunt);
}
