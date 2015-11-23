package main.vo;

//Ö§³öVO
public class CostVO extends ReceiptVO{
	private String accountName;
	private double cost;
	private String comment;
	private CostType type;
	public CostVO(String id, String date, String code,String accountName,double cost,String comment,CostType type) {
		super(id, date, code);
		this.accountName=accountName;
		this.cost=cost;
		this.comment=comment;
		this.type=type;
	}
	public String getAccountname() {
		return accountName;
	}
	public void setAccountname(String accountname) {
		this.accountName = accountname;
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
