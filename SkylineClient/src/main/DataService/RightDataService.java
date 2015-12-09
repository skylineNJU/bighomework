package main.dataservice;

import main.po.AccountListPO;
import main.po.AccountPO;
import main.po.DriverInfoPO;
import main.State.RightType;

//Ȩ�޹������ݽӿ�
public interface RightDataService {

	//�����ʼ��
	//�����˻��������ݿ��е��˻���������Ϊ��ʼֵ
	public boolean initKeyWord(String account);
	
	//ɾ���˻�
	//�����˻��������ݿ��е��˻�ɾ��
	public boolean delAccount(String account);
	
	//����Ȩ��
	//Ȩ��Ӧ������Ϊö������
	//rightTypeΪ��Ҫ���ӵ�Ȩ��
	public boolean changeRight(AccountPO accountPO);
	
	//�����ݿ��ж�ȡ���˻���Ȩ��
	public AccountListPO inquireAccountList(AccountListPO po) ;
	
	public AccountPO login(AccountPO accountInfo);
	//�½��˻�
	public boolean writeAccount(AccountPO po) ;
	//�޸��˻���Ϣ
	public boolean modifyAcount(AccountPO accountPO);

	public boolean delAccount(AccountPO po);
	
}
