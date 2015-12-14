package main.po;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//��¼ÿ����д���ĵ��ݵı���
public class CourrierReceiptPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String account;
	private String orderCode;
	private String buildDate;
	private String receiveCode;
	private String receiveDate;
	private String distributeCode;
	public CourrierReceiptPO(String account, String orderCode, String buildDate, String receiveCode, String receiveDate,
			String distributeCode) {
		super();
		this.account = account;
		this.orderCode = orderCode;
		this.buildDate = buildDate;
		this.receiveCode = receiveCode;
		this.receiveDate = receiveDate;
		this.distributeCode = distributeCode;
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		getDataFromBase();
		deleteFromDatabase();
		String content="'"+account+"','"+orderCode+"','"+buildDate+"','"
				+receiveCode+"','"+receiveDate+"','"+distributeCode+"','"+"δ����"+"'";
		writer.writeIntoSql("CourrierReceipt", content);
	}
	
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("CourrierReceipt","�˻���",account);
	}
	
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("CourrierReceipt");
		reader.findNext("�˻���",account);
		if(orderCode!=null)
			orderCode=reader.getString("��������")+" "+orderCode;
		else
			orderCode=reader.getString("��������");
		
		if(buildDate!=null)
			buildDate=reader.getString("������������")+" "+buildDate;
		else
			buildDate=reader.getString("������������");
		
		if(receiveDate!=null)
			receiveDate=reader.getString("�ռ�����������")+" "+receiveDate;
		else
			receiveDate=reader.getString("�ռ�����������");
		
		if(receiveCode!=null)
			receiveCode=reader.getString("�ռ�������")+" "+receiveCode;
		else
			receiveCode=reader.getString("�ռ�������");
		
		if(distributeCode!=null)
			distributeCode=reader.getString("�ɼ�������")+" "+distributeCode;
		else
			distributeCode=reader.getString("�ɼ�������");
		reader.close();
	}

	public void modify() {
		// TODO Auto-generated method stub
		SqlReader reader=new SqlReader("CourrierReceipt");
		reader.findNext("�˻���",account);
		distributeCode=reader.getString("�ɼ�������");
		this.deleteFromDatabase();
		reader.close();
		SqlWriter writer=new SqlWriter();
		String content="'"+account+"','"+orderCode+"','"+buildDate+"','"
				+receiveCode+"','"+receiveDate+"','"+distributeCode+"'";
		writer.writeIntoSql("CourrierReceipt", content);
	}
}
