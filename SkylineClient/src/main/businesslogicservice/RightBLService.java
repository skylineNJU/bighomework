package main.businesslogicservice;

import main.vo.AccountVO;
import main.vo.BankAccountVO;
import main.vo.RightVO;

public interface RightBLService {
	//�û������˻����ƣ���������¼,ϵͳ���ݷ��ص�Ȩ������תҳ��
	public boolean login(String AccountName,String code,AccountVO account);
	
	//�˻�������Ա�����µ��˻���ϵͳ��ʾ�˻���Ϣ
	public boolean createNewAccount(BankAccountVO accountInfo);
	
	//��˾ְ���޸��˻����룬������ɵ�������µ�����
	public boolean modifyCode(String oldCode,String newCode);
	
	//������Ա���԰�����˾Ա����ʼ�����룬������ְ���˺�
	public boolean initCode(String ID);
}
