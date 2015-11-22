package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class ReceivePO extends Receipt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String bar;
	String receivorName;
	String receiveDate;
	
	public ReceivePO(String a,String b,String c){
		bar = a;
		receivorName = b;
		receiveDate = c;
	}

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+this.getCode()+"','"+bar+"','"+receivorName+"','"
				+receiveDate+"'";
		writer.writeIntoSql("Receive", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Receive");
		reader.findNext("收件单单号",this.getCode());
		this.bar=reader.getString("订单单号");
		this.receiveDate=reader.getString("收件时间");
		this.receivorName=reader.getString("收件人姓名");
	}
	
	public String getBar() {
		return bar;
	}

	public String getReceivorName() {
		return receivorName;
	}

	public String getReceiveDate() {
		return receiveDate;
	}
	
	
}
