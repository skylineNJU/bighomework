package vo;

public class CostVO extends ReceiptVO{
	private String accountname;
	private double cost;
	private String ps;
	private CostType type;
	public CostVO(String id, String da, String co,String an,double cos,String p,CostType ty) {
		super(id, da, co);
		this.accountname=an;
		this.cost=cos;
		this.ps=p;
		this.type=ty;
		// TODO Auto-generated constructor stub
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	public CostType getCostType() {
		return type;
	}
	public void setCostType(CostType type) {
		this.type = type;
	}
	
	

}
