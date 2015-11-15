package businesslogic.receivebl;
import po.OrderPO;
import vo.OrderVO;

public class Order {
	private String senderName;
	private String senderAddress;
	private String senderCom;
	private String senderMobile;
	
	private String receivorName;
	private String receivorAddress;
	private String receivorCom;
	//private String receivortel;
	private String receivorMobile;
	private OrderVO po;
	//
	public Order(OrderVO or){
		this.senderName=or.getName1();//�ļ���
		this.senderAddress=or.getPosition1();
		this.senderCom=or.getUnit1();
		this.senderMobile=or.getPhoneNumber1();
		this.receivorName=or.getName2();
		this.receivorAddress=or.getPosition2();
		this.receivorCom=or.getUnit2();
		this.receivorMobile=or.getPhoneNumber2();	
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getSenderCom() {
		return senderCom;
	}
	public void setSenderCom(String senderCom) {
		this.senderCom = senderCom;
	}
	public String getSenderMobile() {
		return senderMobile;
	}
	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}
	public String getReceivorName() {
		return receivorName;
	}
	public void setReceivorName(String receivorName) {
		this.receivorName = receivorName;
	}
	public String getReceivorAddress() {
		return receivorAddress;
	}
	public void setReceivorAddress(String receivorAddress) {
		this.receivorAddress = receivorAddress;
	}
	public String getReceivorCom() {
		return receivorCom;
	}
	public void setReceivorCom(String receivorCom) {
		this.receivorCom = receivorCom;
	}
	public String getReceivorMobile() {
		return receivorMobile;
	}
	public void setReceivorMobile(String receivorMobile) {
		this.receivorMobile = receivorMobile;
	}
	
	
}
