package test.data_stub;

import  main.dataservice.RightDataService;
import main.po.AccountListPO;
import  main.po.AccountPO;
import main.po.Rights;
import  main.State.RightType;
/**
 * 
 * @author QiHan
 * 
 *
 */
public class RightDataService_Stub implements RightDataService {
	

	//�����ʼ��
	//�����˻��������ݿ��е��˻���������Ϊ��ʼֵ
	public boolean initKeyWord(String account){
		System.out.println("init Succeed!/n");
		return true;
	}
	
	//ɾ���˻�
	//�����˻��������ݿ��е��˻�ɾ��
	public boolean delAccount(String account){
		System.out.println("delete Succeed!/n");
		return true;
	}
	
	//����Ȩ��
	//Ȩ��Ӧ������Ϊö������
	//rightTypeΪ��Ҫ���ӵ�Ȩ��
	public boolean changeRight(AccountPO accountPO){
		System.out.println("change Succeed!/n");
		return true;
	}
	
	//�����ݿ��ж�ȡ���˻���Ȩ��
	public RightType readRight(String accpunt){
		System.out.println("Succeed!/n");
		return RightType.LOOKTASK;
	}

	@Override
	public AccountListPO inquireAccountList(AccountListPO po) {
		// TODO Auto-generated method stub
		po = new AccountListPO();
		return po;
	}

	@Override
	public AccountPO login(AccountPO accountInfo) {
		// TODO Auto-generated method stub
		accountInfo = new AccountPO("213131", "12345678",Rights.STOREHOUSE, null);
		return accountInfo;
	}

	@Override
	public boolean writeAccount(AccountPO po) {
		// TODO Auto-generated method stub
		po= new AccountPO("213131", "12345678",Rights.STOREHOUSE, null);
		if(po.getCode()!=null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean modifyAcount(AccountPO accountPO) {
		// TODO Auto-generated method stub
		accountPO	= new AccountPO("213131", "12345678",Rights.STOREHOUSE, null);
		if(accountPO.getCode()!=null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean delAccount(AccountPO po) {
		// TODO Auto-generated method stub
		po = new AccountPO("213131", "12345678",Rights.STOREHOUSE, null);
		if(po.getCode()!=null){
			return true;
		}
		else{
			return false;
		}
	}

}
