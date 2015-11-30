package main.po;
import java.io.Serializable;

public class DistributePO extends Receipt implements Serializable{

	private static final long serialVersionUID = 1L;

	private String bar;//娲句欢鍗曞彿
	private String courierName;//娲鹃�佸憳濮撳悕
	private String orderCode;//订单号
	private String guestName;
	private String guestAddress;
	private String guestPhoneNumber;
	
	public DistributePO(String bar, String orderCode,String guestName, 
			String guestAddress, String guestPhoneNumber, String courierName) {
		super();
		this.bar = bar;
		this.courierName = courierName;
		this.orderCode = orderCode;
		this.guestName = guestName;
		this.guestAddress = guestAddress;
		this.guestPhoneNumber = guestPhoneNumber;
	}
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getBar() {
		return bar;
	}
	public void setBar(String bar) {
		this.bar = bar;
	}
	public String getCourrierName() {
		return courierName;
	}
	public void setCourrierName(String courrierName) {
		this.courierName = courrierName;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestAddress() {
		return guestAddress;
	}
	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}
	public String getGuestPhoneNumber() {
		return guestPhoneNumber;
	}
	public void setGuestPhoneNumber(String guestPhoneNumber) {
		this.guestPhoneNumber = guestPhoneNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
