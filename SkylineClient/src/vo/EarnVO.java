package vo;

public class EarnVO extends ReceiptVO{
	private String[] name=new String[50];
	private double[] fee=new double[50];
	private String Lobbycode;
	public EarnVO(String id, String da, String co) {
		super(id, da, co);
		// TODO Auto-generated constructor stub
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
