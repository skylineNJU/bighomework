package main.vo;

//֧��VO
public class CostVO extends ReceiptVO{
	private String bankAccount;
	private double cost;
	private String comment;
	private CostType type;
	
	//�޲������캯��
	public CostVO(){}
	//ID ֧�����˻���date֧�����ڣ�code�õ��ݵ��ţ�bankAccount�����˻���cost֧�����ã�comment��ע��typy֧������
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
