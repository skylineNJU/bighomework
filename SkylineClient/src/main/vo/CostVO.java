package main.vo;

//֧��VO
public class CostVO extends ReceiptVO{
	
	private String bankAccount;
	private double cost;
	private String comment;
	private String type;
	private String date;
	private String costCode;
	
	//ID ֧�����˻���date֧�����ڣ�code�õ��ݵ��ţ�bankAccount�����˻���cost֧�����ã�comment��ע��typy֧������
	public CostVO(String date, String code,String bankAccount,double cost,String comment,String type) {
		super(code);
		this.costCode = code;
		this.date = date;
		this.bankAccount=bankAccount;
		this.cost=cost;
		this.comment=comment;
		this.type=type;
	}

	public String getCostCode() {
		return costCode;
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
