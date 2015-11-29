package main.po;

import main.socketservice.SqlDeleter;
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
	private String lobbyLoading;
	
	
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		getDataFromBase();
		this.deleteFromDatabase();
		String content="'"+accountName+"','"+receiveCode+"','"+earnCode+"','"
				+receiveDate+"','"+earnDate+"','"+lobbyLoading+"'";
		writer.writeIntoSql("LobbyReceipt", content);
	}

	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("LobbyReceipt","账户名",accountName);
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
		if(lobbyLoading!=null)
			lobbyLoading=reader.getString("营业厅装运单单号")+" "+lobbyLoading;
		else
			lobbyLoading=reader.getString("营业厅装运单单号");
		reader.close();
	}
}
