package main.vo;

//支出VO
public class CostVO extends ReceiptVO{
	private String bankAccount;
	private double cost;
	private String comment;
	private CostType type;
	
	//无参数构造函数
	public CostVO(){}
	//ID 支出人账户，date支出日期，code该单据单号，bankAccount银行账户，cost支出费用，comment备注，typy支出类型
	public CostVO(String id, String date, String code,String bankAccount,double cost,String comment,CostType type) {
		super(id, date, code);
		this.bankAccount=bankAccount;
		this.cost=cost;
		this.comment=comment;
		this.type=type;
	}
	public boolean wirte(CostVO costVO){
		super.write(costVO);
		this.bankAccount = costVO.getBankAccount();
		this.cost = costVO.getCost();
		this.comment = costVO.getComment();
		this.type = costVO.type;
		return true;
	}
	public String getComment() {
		return comment;
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
	public void setType(CostType type) {
		this.type = type;
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
	public String getPs() {
		return comment;
	}
	public void setPs(String comment) {
		this.comment = comment;
	}
	public CostType getCostType() {
		return type;
	}
	public void setCostType(CostType type) {
		this.type = type;
	}
}
