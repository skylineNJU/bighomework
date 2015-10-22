package logicservice;

import vo.AccountVO;
import vo.RightVO;

public interface RightBLService {
	//�û������˻����ƣ���������¼,ϵͳ���ݷ��ص�Ȩ������תҳ��
	public RightVO login(String AccountName,String code);
	
	//�˻�������Ա�����µ��˻���ϵͳ��ʾ�˻���Ϣ
	public AccountVO createNewAccount(String ID,String code,RightVO right);
	
	//��˾ְ���޸��˻����룬������ɵ�������µ�����
	public boolean modifyCode(String oldCode,String newCode);
	
	//������Ա���԰�����˾Ա����ʼ�����룬������ְ���˺�
	public boolean initCode(String ID);
}
