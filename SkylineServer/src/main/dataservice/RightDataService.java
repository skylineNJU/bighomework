package main.dataservice;

import java.util.List;

import main.po.AccountPO;
import main.po.PlaneLoadingPO;
import main.po.TrainLoadingPO;
import main.State.RightType;

//Ȩ�޹������ݽӿ�
public interface RightDataService {

	//�����ʼ��
	//�����˻��������ݿ��е��˻���������Ϊ��ʼֵ
	public boolean initKeyWord(String account);
	//�½��˻�
	public void writeAccount(List<AccountPO> loadList,String accountCode);
	//ɾ���˻�
	//�����˻��������ݿ��е��˻�ɾ��
	public void delAccount(List<AccountPO> accountList);
	public void delAccount();
	
	//����Ȩ��
	//Ȩ��Ӧ������Ϊö������
	//rightTypeΪ��Ҫ���ӵ�Ȩ��
	public boolean changeRight(AccountPO accpuntPO);
	
	//�����ݿ��ж�ȡ���˻���Ȩ��
	public RightType readRight(String account);
	
	//�����ݿ��ȡ�˻���Ϣ  LoadList��װ����Ϣ
		public List<AccountPO> readAccount();
		
	
		
}
