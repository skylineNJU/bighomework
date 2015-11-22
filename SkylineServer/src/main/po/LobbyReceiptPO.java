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
		
		reader.close();
	}
}
