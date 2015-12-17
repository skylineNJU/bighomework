package main.po;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//一项收入的收款单PO
public class CollectionPO extends Receipt{
	
	private static final long serialVersionUID = 1L;
	private String date;
	private String unit;//收款单位，即编号
	private String bankAccount;
	private double money;//收款金额
	private String remark;//备注
	private String collectionCode;
	private String isPaid;
	
	public CollectionPO(String collectionCode, String date, String unit, String bankAccount, double money, String remark,String isPaid) {
		super();
		this.collectionCode = collectionCode;
		this.date = date;
		this.unit = unit;
		this.bankAccount = bankAccount;
		this.money = money;
		this.remark = remark;
		this.isPaid = isPaid;
	}
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+collectionCode+"','"+date+"','"+unit+"','"+bankAccount+"',"+money+",'"
				+remark+"','"+isPaid+"'";
		writer.writeIntoSql("Collection", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Collection");
		reader.findNext("入款单单号",this.getCode());
		this.date = reader.getString("收入日期");
		this.unit=reader.getString("收入单位");
		this.bankAccount=reader.getString("收入账户");
		this.money=reader.getDouble("收入金额");
		this.remark=reader.getString("备注");
	}
	
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("Collection","入款单单号",collectionCode);
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
