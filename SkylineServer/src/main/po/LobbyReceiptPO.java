package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class LobbyReceiptPO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountName;
	private String receiveCode;
	private String earnCode;
	private String receiveDate;
	private String earnDate;
	public LobbyReceiptPO(String accountName, String receiveCode, String earnCode, String receiveDate,
			String earnDate) {
		super();
		this.accountName = accountName;
		this.receiveCode = receiveCode;
		this.earnCode = earnCode;
		this.receiveDate = receiveDate;
		this.earnDate = earnDate;
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		getDataFromBase();
		String content="'"+accountName+"','"+receiveCode+"','"+earnCode+"','"
				+receiveDate+"','"+earnDate+"'";
		writer.writeIntoSql("LobbyReceipt", content);
	}

	public void getDataFromBase(){
		SqlReader reader=new SqlReader("LobbyReceipt");
		reader.findNext("账户名",accountName);
		if(receiveCode!=null)
			receiveCode=reader.getString("接收单单号")+" "+receiveCode;
		else
			receiveCode=reader.getString("接收单单号");
	
		if(earnCode!=null)
			earnCode=reader.getString("入款单单号")+" "+earnCode;
		else
			earnCode=reader.getString("入款单单号");
		
		if(receiveDate!=null)
			receiveDate=reader.getString("接收单生成时间")+" "+receiveDate;
		else
			receiveDate=reader.getString("接收单生成时间");
		
		if(earnDate!=null)
			earnDate=reader.getString("入款单生成时间")+" "+earnDate;
		else
			earnDate=reader.getString("入款单生成时间");
		
		reader.close();
	}
}
