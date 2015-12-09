package test.data_stub;

import java.util.ArrayList;
import java.util.List;

import main.dataservice.FinanceDataService;
import main.po.BankAccountPO;
import main.po.BankList;
import main.po.CollectionPO;
import main.po.CollectionPOList;
import main.po.CostPO;
import main.po.CostPOList;
import main.po.DistancePO;
import main.po.FeePO;
import main.po.LobbyEarnPO;
import main.po.SalaryPO;

public class FinanceDataService_Stub implements FinanceDataService{
	List<CostPO> costlist =new ArrayList<CostPO>();
	CostPO readCost;
	CostPOList costPOList=new CostPOList();
	List<CollectionPO> Collectionlist = new ArrayList<CollectionPO>();
	CollectionPO collectionPO;
	CollectionPOList collList=new CollectionPOList();
	BankAccountPO bankAccountPO;
	FeePO feePO=new FeePO(0, 0, 0);
	@Override
	//��ȡ�ɱ������
	//�ɱ���ĿΪö������
	//���������Ͳ��������ݿ���ĳɱ�������Ϣ
	public CostPOList readCost(String date) {
		// TODO Auto-generated method stub
		readCost = new CostPO("111111","20","fast",date,"","","");
		costlist.clear();
		costlist.add(readCost);
		return costPOList;
	}

	@Override
	//���ɱ�����Ϣ�洢�����ݿ�
	public boolean writeCost(CostPO costPO) {
		// TODO Auto-generated method stub
		System.out.println("-----------------Save in database Success!-----------------");
		return true;
	}


	@Override
	//�޸ĳɱ���Ϣ
	public boolean modifiyCost(CostPO costPO) {
		// TODO Auto-generated method stub
		costPO = new CostPO("111111","20","fast","","","","");
		return true;
	}

	@Override
	//��ȡ������Ϣ
	//������ĿӦ��Ϊö������
	//���������������ݿ����������ľ�����Ϣ
	public CollectionPOList readCollection(String date) {
		// TODO Auto-generated method stub
		collectionPO = new CollectionPO("2333","12","66666","2003", 3,"6154434569087098711","��");
		Collectionlist.clear();
		Collectionlist.add(collectionPO);
		return collList;
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
		collectionPO = new CollectionPO("2333","12","66666","2003", 3,"6154434569087098711","��");
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
	public boolean delFee(FeePO feePO) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean delCollection(CollectionPO collectionPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delDistance(DistancePO distancePO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCost(CostPO costPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyBalance(BankAccountPO bankPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SalaryPO readSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delSalary(SalaryPO salaryPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FeePO readFee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LobbyEarnPO readLobbyEarn(String date, String unit) {
		// TODO Auto-generated method stub
		return null;
	}
	//�����ݿ����ȡ�����˻���Ϣ
		//���������˻����˻�����
	@Override
	public BankList readBankAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeSalary(SalaryPO salaryPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DistancePO readDistance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeFee(FeePO feePO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean writeDistance(DistancePO distancePO) {
		// TODO Auto-generated method stub
		return false;
	}

}
