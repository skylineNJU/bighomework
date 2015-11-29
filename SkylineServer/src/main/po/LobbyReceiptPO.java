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
		deleter.deleteData("LobbyReceipt","�˻���",accountName);
	}
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("LobbyReceipt");
		reader.findNext("�˻���",accountName);
		if(receiveCode!=null)
			receiveCode=reader.getString("���յ�����")+" "+receiveCode;
		else
			receiveCode=reader.getString("���յ�����");
	
		if(earnCode!=null)
			earnCode=reader.getString("������")+" "+earnCode;
		else
			earnCode=reader.getString("������");
		
		if(receiveDate!=null)
			receiveDate=reader.getString("���յ�����ʱ��")+" "+receiveDate;
		else
			receiveDate=reader.getString("���յ�����ʱ��");
		
		if(earnDate!=null)
			earnDate=reader.getString("������ʱ��")+" "+earnDate;
		else
			earnDate=reader.getString("������ʱ��");
		if(lobbyLoading!=null)
			lobbyLoading=reader.getString("Ӫҵ��װ�˵�����")+" "+lobbyLoading;
		else
			lobbyLoading=reader.getString("Ӫҵ��װ�˵�����");
		reader.close();
	}
}
