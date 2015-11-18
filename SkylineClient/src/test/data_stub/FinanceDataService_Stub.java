package test.data_stub;

import java.util.ArrayList;
import java.util.List;

import main.dataservice.FinanceDataService;
import main.po.BankAccountPO;
import main.po.CollectionPO;
import main.po.CostPO;

public class FinanceDataService_Stub implements FinanceDataService{
	List<CostPO> costlist =new ArrayList<CostPO>();
	CostPO readCost;
	List<CollectionPO> Collectionlist = new ArrayList<CollectionPO>();
	CollectionPO collectionPO;
	BankAccountPO bankAccountPO;
	
	@Override
	//��ȡ�ɱ������
	//�ɱ���ĿΪö������
	//���������Ͳ��������ݿ���ĳɱ�������Ϣ
	public boolean readCost(String Date,List<CostPO> costList) {
		// TODO Auto-generated method stub
		readCost = new CostPO("����",2007,"10",Date,60000,"6172271990182736654","01","��");
		costlist.clear();
		costlist.add(readCost);
		return true;
	}

	@Override
	//���ɱ�����Ϣ�洢�����ݿ�
	public boolean writeCost(CostPO costPO) {
		// TODO Auto-generated method stub
		System.out.println("-----------------Save in database Success!-----------------");
		return true;
	}

	@Override
	//ɾ���ɱ���Ϣ
	public boolean delCost(CostPO costPO) {
		// TODO Auto-generated method stub
		System.out.println("-----------------Delect Success!-----------------");
		return true;
	}

	@Override
	//�޸ĳɱ���Ϣ
	public boolean modifiyCost(CostPO costPO) {
		// TODO Auto-generated method stub
		costPO = new CostPO("����",2007,"10","24",60000,"6172271990182736654","B��˾","��");
		return true;
	}

	@Override
	//��ȡ������Ϣ
	//������ĿӦ��Ϊö������
	//���������������ݿ����������ľ�����Ϣ
	public boolean readCollection(List<CollectionPO> Collectionlist) {
		// TODO Auto-generated method stub
		collectionPO = new CollectionPO(2006,"12","09","01","6154434569087098711",91000,"��");
		Collectionlist.clear();
		Collectionlist.add(collectionPO);
		return true;
	}

	@Override
	public boolean readCollection(String lobbyCode,List<CollectionPO> Collectionlist) {
		// TODO Auto-generated method stub
		collectionPO = new CollectionPO(2007,"12","09",lobbyCode,"6154434569087098711",91000,"��");	
		Collectionlist.clear();
		Collectionlist.add(collectionPO);
		return true;
	}

	@Override
	public boolean readCollection(String date1, String date2,List<CollectionPO> Collectionlist) {
		// TODO Auto-generated method stub
	    collectionPO = new CollectionPO(2008,"12","09","01","6154434569087098711",91000,"��");
		Collectionlist.clear();
		Collectionlist.add(collectionPO);
		return true;
	}

	@Override
	//��������Ϣ�洢�����ݿ�
	public boolean writeCollection(CollectionPO collectionPO) {
		// TODO Auto-generated method stub
		System.out.println("---------------Write in database Success!---------------");
		return true;
	}

	@Override
	//�޸��տ���Ϣ
	public boolean modifiyCollection(CollectionPO collectionPO) {
		// TODO Auto-generated method stub
		collectionPO = new CollectionPO(2006,"12","09","01","6154434569087098711",10000,"��");
		return true;
	}

	@Override
	//�����ݿ����ȡ�����˻���Ϣ
	//���������˻����˻�����
	public boolean readBankAccount(String bankAccount,BankAccountPO account) {
		// TODO Auto-generated method stub
	    bankAccountPO=new BankAccountPO(bankAccount,10000000);
		return true;
	}

	@Override
	//д��Ϣ
	public boolean writeBankAccount(BankAccountPO bankAccountPO) {
		// TODO Auto-generated method stub
		System.out.println("-----------------Write Success!-----------------");
		return false;
	}

	@Override
	public boolean delBankAccount(BankAccountPO bankAccountPO) {
		// TODO Auto-generated method stub
		System.out.println("-----------------Delect Scuccess!-----------------");
		return false;
	}

}
