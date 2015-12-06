package main.vo;

public class EarnVO extends ReceiptVO{

	private static final long serialVersionUID = 1L;
	private String collectionCode;
	private String date;
	private String unit;//收款单位，即编号
	private String bankAccount;//收款人账户
	private double money;//收款金额
	private String remark;//备注
	private String isPaid;
	
	public EarnVO(String collectionCode, String date, String unit,
			String bankAccount, double money, String remark,String isPaid) {
		super(collectionCode);
		this.collectionCode = collectionCode;
		this.date = date;
		this.unit = unit;
		this.bankAccount = bankAccount;
		this.money = money;
		this.remark = remark;
		this.isPaid = isPaid;
	}

	public String getCollectionCode() {
		return collectionCode;
	}
	
	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
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
