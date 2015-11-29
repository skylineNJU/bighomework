package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class DistributePO extends Receipt implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bar;
	private String courrierName;//快递员的编号
	private String GuestName;
	private String GuestAdress;
	private String GuestPhoneNumber;
	private String order;//订单号
	
	public DistributePO(String bar,String courrierName
			, String order,String GuestName,String GuestAdress,String GuestPhoneNumber){
		this.bar=bar;
		this.courrierName=courrierName;
		this.order = order;
		this.GuestName=GuestName;
		this.GuestAdress=GuestAdress;
		this.GuestPhoneNumber=GuestPhoneNumber;
	}

	
	public String getOrder() {
		return order;
	}


	public void setOrder(String order) {
		this.order = order;
	}


	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+super.getCode()+"','"+courrierName+"','"+GuestName
				+"','"+GuestAdress+"','"+GuestPhoneNumber+"','"+bar+"'";
		writer.writeIntoSql("Distribute", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Distribute");
		reader.findNext("快递员账号",this.getCourrierName());
		this.courrierName=reader.getString("快递员账号");
		this.GuestName=reader.getString("收件人姓名");
		this.GuestAdress=reader.getString("收件人地址");
		this.GuestPhoneNumber=reader.getString("收件人手机号");
		this.bar=reader.getString("订单号");
		
		reader.close();
	}
	
	public String getBar() {
		return bar;
	}

	public String getCourrierName() {
		return courrierName;
	}



	public String getGuestName() {
		return GuestName;
	}



	public void setGuestName(String guestName) {
		GuestName = guestName;
	}



	public String getGuestAdress() {
		return GuestAdress;
	}



	public void setGuestAdress(String guestAdress) {
		GuestAdress = guestAdress;
	}



	public String getGuestPhoneNumber() {
		return GuestPhoneNumber;
	}



	public void setGuestPhoneNumber(String guestPhoneNumber) {
		GuestPhoneNumber = guestPhoneNumber;
	}
	
	
}
