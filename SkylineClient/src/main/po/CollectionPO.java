package main.po;

import main.vo.ReceiptVO;

//һ��������տPO
public class CollectionPO extends Receipt{
	
	private static final long serialVersionUID = 1L;
	private String date;
	private String unit;//�տλ�������
	private String bankAccount;//�տ����˻�
	private double money;//�տ���
	private String remark;//��ע
	private String collectionCode;
	private String isPaid;
	
	public CollectionPO(String collectionCode,String date,String unit,String bankAccount,double money,String remark,String isPaid){
		super();
		this.collectionCode = collectionCode;
		this.date = date;
		this.unit = unit;
		this.bankAccount = bankAccount;
		this.money = money;
		this.remark = remark;
		this.isPaid = isPaid;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public String getCollectionCode() {
		return collectionCode;
	}

	public void setCollectionCode(String collectionCode) {
		this.collectionCode = collectionCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
