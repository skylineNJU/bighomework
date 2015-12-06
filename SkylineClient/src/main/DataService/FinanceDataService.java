package main.dataservice;

import java.util.ArrayList;

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
//�������
public interface FinanceDataService {
	
	public boolean delFee(FeePO feePO);
	
	public boolean delCollection(CollectionPO collectionPO);
	
	public boolean delDistance(DistancePO distancePO);
	
	public boolean deleteCost(CostPO costPO);
	
	public boolean modifyBalance(BankAccountPO bankPO);
	
	public SalaryPO readSalary();
	
	public boolean delSalary(SalaryPO salaryPO);
	
	public FeePO readFee();
	
	public LobbyEarnPO readLobbyEarn(String date,String unit);
	
	public CostPOList readCost(String date);

	//���ɱ�����Ϣ�洢�����ݿ�
	public boolean writeCost(CostPO costPO);
	
	//�޸ĳɱ���Ϣ
	public boolean modifiyCost(CostPO costPO);
	
	public CollectionPOList readCollection(String date);
	
	//��������Ϣ�洢�����ݿ�
	public boolean writeCollection(CollectionPO collectionPO);
	
	//�޸��տ���Ϣ
	
	public boolean modifiyCollection(CollectionPO collectionPO);
	
	//�����ݿ����ȡ�����˻���Ϣ
	//���������˻����˻�����
	public BankList readBankAccount();
	
	//д��Ϣ
	public boolean writeBankAccount(BankAccountPO bankAccountPO);
	
	public boolean writeSalary(SalaryPO salaryPO);
	
	public DistancePO readDistance();
	
	public boolean writeFee(FeePO feePO);
	
	public boolean writeDistance(DistancePO distancePO);
}
