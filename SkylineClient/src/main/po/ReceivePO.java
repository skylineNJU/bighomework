package main.po;
import java.io.Serializable;
//鎺ユ敹鍗�
public class ReceivePO extends Receipt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String bar;
	String receivorName;
	String receivorPhone;
	String courierCode;
	String receiveDate;
	public ReceivePO(String bar, String receivorName, String receivorPhone,
			String courierCode, String receiveDate) {
		super();
		this.bar = bar;
		this.receivorName = receivorName;
		this.receivorPhone = receivorPhone;
		this.courierCode = courierCode;
		this.receiveDate = receiveDate;
	}
	public String getBar() {
		return bar;
	}
	public void setBar(String bar) {
		this.bar = bar;
	}
	public String getReceivorName() {
		return receivorName;
	}
	public void setReceivorName(String receivorName) {
		this.receivorName = receivorName;
	}
	public String getReceivorPhone() {
		return receivorPhone;
	}
	public void setReceivorPhone(String receivorPhone) {
		this.receivorPhone = receivorPhone;
	}
	public String getCourierCode() {
		return courierCode;
	}
	public void setCourierCode(String courierCode) {
		this.courierCode = courierCode;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
