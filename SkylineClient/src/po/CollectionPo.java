package PO;

//һ��������տPO
public class CollectionPO {
	
	private int collectionYear;//�������
	private int collectionMonth;//�����·�
	private int collectionDay;//������
	private int unit;//�տλ�������
	private String account;//�տ����˻�
	private int money;//�տ���
	private String remark;//��ע
	
	public CollectionPO(int collectionYear,int collectionMonth,int collectionDay,int unit,String account,int money,String remark){
		this.collectionYear = collectionYear;
		this.collectionMonth = collectionMonth;
		this.collectionDay = collectionDay;
		this.unit = unit;
		this.account = account;
		this.money = money;
		this.remark = remark;
	}

	public int getCollectionYear() {
		return collectionYear;
	}

	public int getCollectionMonth() {
		return collectionMonth;
	}

	public int getCollectionDay() {
		return collectionDay;
	}

	public int getUnit() {
		return unit;
	}

	public String getAccount() {
		return account;
	}

	public int getMoney() {
		return money;
	}

	public String getRemark() {
		return remark;
	}
	
}
