package main.po;
import java.io.Serializable;

public class DistributePO extends Receipt implements Serializable{

	private static final long serialVersionUID = 1L;

	private String bar;//娲句欢鍗曞彿
	private String courrierName;//娲鹃�佸憳濮撳悕
	private String order;//订单号
	private String guestName;
	private String guestAddress;
	private String guestPhone;
	
	public DistributePO(String bar, String courrierName, String order,
			String guestName, String guestAddress, String guestPhone) {
		super();
		this.bar = bar;
		this.courrierName = courrierName;
		this.order = order;
		this.guestName = guestName;
		this.guestAddress = guestAddress;
		this.guestPhone = guestPhone;
	}
	
	
	public String getBar() {
		return bar;
	}
	public void setBar(String bar) {
		this.bar = bar;
	}
	public String getCourrierName() {
		return courrierName;
	}
	public void setCourrierName(String courrierName) {
		this.courrierName = courrierName;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
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
	public String getGuestPhone() {
		return guestPhone;
	}
	public void setGuestPhone(String guestPhone) {
		this.guestPhone = guestPhone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
