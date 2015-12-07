package main.po;
import java.io.Serializable;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

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

	public void writeIntoDatabase(){
		if(this.deleteDistributeTask()){
		SqlWriter writer=new SqlWriter();
		String content="'"+bar+"','"+receivorName+"','"
				+receiveDate+"','"+receivorPhone+"','"+courierCode+"'";
		writer.writeIntoSql("Receive", content);
		this.setKey("success");
		}
	}
	
	public boolean deleteDistributeTask(){
		SqlDeleter deleter=new SqlDeleter();
		System.out.println(bar+"--------------");
		if(deleter.deleteData("Distribute","订单号",courierCode)){
			return true;
		}
		return false;
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Receive");
		reader.findNext("收件单单号",this.getCode());
		this.bar=reader.getString("订单单号");
		this.receiveDate=reader.getString("收件时间");
		this.receivorName=reader.getString("收件人姓名");
		this.courierCode=reader.getString("快递员账号");
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
