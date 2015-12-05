package main.vo;

//支出VO
public class CostVO extends ReceiptVO{
	
	private String bankAccount;
	private double cost;
	private String comment;
	private String type;
	private String date;
	private String costCode;
	private String isPaid;
	
	//ID 支出人账户，date支出日期，code该单据单号，bankAccount银行账户，cost支出费用，comment备注，typy支出类型
	public CostVO(String date, String code,String bankAccount,double cost,String comment,String type,String isPaid) {
		super(code);
		this.costCode = code;
		this.date = date;
		this.bankAccount=bankAccount;
		this.cost=cost;
		this.comment=comment;
		this.type=type;
		this.isPaid = isPaid;
	}

	public String getCostCode() {
		return costCode;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public void setCostCode(String costCode) {
		this.costCode = costCode;
	}

	public String getComment() {
		return comment;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setAccountname(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getCostType() {
		return type;
	}
	public void setCostType(String type) {
		this.type = type;
	}
}
