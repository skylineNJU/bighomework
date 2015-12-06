package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class DistributePO extends Receipt implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bar;
	private String courierName;//快递员的编号
	private String orderCode;//订单号
	private String guestName;
	private String guestAddress;
	private String guestPhoneNumber;
	
	public DistributePO(String bar, String orderCode,String guestName, 
			String guestAddress, String guestPhoneNumber, String courierName){
		super();
		this.bar = bar;
		this.courierName = courierName;
		this.orderCode = orderCode;
		this.guestName = guestName;
		this.guestAddress = guestAddress;
		this.guestPhoneNumber = guestPhoneNumber;
	}

	public String getOrderCode() {
		return this.orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+courierName+"','"+bar+"','"+orderCode+"','"
		+guestName+"','"+guestAddress+"','"+guestPhoneNumber+"'";
		writer.writeIntoSql("Distribute", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Distribute");
		if(reader.findNext("快递员账号",this.getCourrierName())){
			this.courierName=reader.getString("快递员账号");
			this.guestName=reader.getString("收件人姓名");
			this.guestAddress=reader.getString("收件人地址");
			this.guestPhoneNumber=reader.getString("收件人手机号");
			this.bar=reader.getString("派送单号");	
			this.orderCode = reader.getString("订单号");
		}
		reader.close();
	}
	
	public String getBar() {
		return bar;
	}

	public String getCourrierName() {
		return courierName;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestAdress() {
		return guestAddress;
	}

	public void setGuestAdress(String guestAddress) {
		this.guestAddress = guestAddress;
	}

	public String getGuestPhoneNumber() {
		return guestPhoneNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	public void setCourrierName(String courrierName) {
		this.courierName = courrierName;
	}

	public void setGuestPhoneNumber(String guestPhoneNumber) {
		this.guestPhoneNumber = guestPhoneNumber;
	}
	
	
}
