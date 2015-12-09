package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.AccountVO;
import main.vo.BankAccountVO;
import main.vo.DriverVO;
import main.vo.StaffVO;

public interface RightBLService {
	//�û������˻����ƣ���������¼,ϵͳ���ݷ��ص�Ȩ������תҳ��
	public boolean login(AccountVO account);
	
	//�˻�������Ա�����µ��˻���ϵͳ��ʾ�˻���Ϣ
	public boolean createNewAccount(AccountVO accountInfo);
	//�˻�������Ա��ѯ�˻�
	public boolean inquireAccount(String code,AccountVO account);
	
	//��˾ְ���޸��˻����룬������ɵ�������µ�����
	public boolean modifyCode(String oldCode,String newCode);
	
	//������Ա���԰�����˾Ա����ʼ�����룬������ְ���˺�
	public boolean initCode(String ID);
	
	ArrayList<AccountVO> inquireAccount(String code);

	//ɾ��һ���˺���Ϣ��ϵͳ��ʾɾ���ɹ�
	public boolean deleteAccount(String accountName);
		
		
	//�޸��˺���Ϣ��ϵͳ��ʾ�޸ĺ��ְ����Ϣ
	public boolean modifyAccount(AccountVO accountInfo);

	public ArrayList<AccountVO> inquireAccount();
}
