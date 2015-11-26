package main.vo;

public class EarnVO extends ReceiptVO{
	private String[] name=new String[50];
	private double[] fee=new double[50];
	private String Lobbycode;
	
	//无参数构造函数
	public EarnVO(){}
	
	public EarnVO(String id, String date, String code) {
		super(id, date, code);
	}
	public boolean write(EarnVO earnVO){
		this.ID = earnVO.getID();
		this.date = earnVO.getDate();
		this.code = earnVO.getCode();
		return true;
	}
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public double[] getFee() {
		return fee;
	}
	public void setFee(double[] fee) {
		this.fee = fee;
	}
	public String getLobbycode() {
		return Lobbycode;
	}
	public void setLobbycode(String lobbycode) {
		Lobbycode = lobbycode;
	}
	
	

}
