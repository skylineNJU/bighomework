package DataService;

import PO.BankAccountPO;
import PO.CollectionPO;
import PO.CostPO;

//�������
public interface FinanceDataService {
	
	//��ȡ�ɱ������
	//�ɱ���ĿΪö������
	//���������Ͳ��������ݿ���ĳɱ�������Ϣ
	public CostPO readCost(CostType costType);
	
	//���ɱ�����Ϣ�洢�����ݿ�
	public void writeCost(CostPO costPO);
	
	//ɾ���ɱ���Ϣ
	public void delCost(CostPO costPO);
	
	//�޸ĳɱ���Ϣ
	public CostPO modifiyCost(CostPO costPO);
	
	//��ȡ������Ϣ
	//������ĿӦ��Ϊö������
	//���������������ݿ����������ľ�����Ϣ
	public CollectionPO readCollection(CollectionType collectionType);
	
	//��������Ϣ�洢�����ݿ�
	public void writeCollection(CollectionPO collectionPO);
	
	//ɾ���տ���Ϣ
	public void delCollection(CollectionPO collectionPO);
	
	//�޸��տ���Ϣ
	
	public CollectionPO modifiyCollection(CollectionPO collectionPO);
	
	//�����ݿ����ȡ�����˻���Ϣ
	//���������˻����˻�����
	public BankAccountPO readBankAccount(String bankAccount);
	
	//д��Ϣ
	public void writeBankAccount(BankAccountPO bankAccountPO);
	
	public void delBankAccount(BankAccountPO bankAccountPO);
	
	public BankAccountPO modifiyBankAccount(BankAccountPO bankAccountPO);
}
