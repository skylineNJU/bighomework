package main.po;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class IntermediateReceipt extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountName;
	private String intermReceiptCode;
	private String airLoadCode;
	private String railLoadCode;
	private String roadLoadCode;
	private String airLoadDate;
	private String railLoadDate;
	private String roadLoadDate;
	private String intermDate;
	public IntermediateReceipt(String accountName, String intermReceiptCode, String airLoadCode, String railLoadCode,
			String roadLoadCode, String airLoadDate, String railLoadDate, String roadLoadDate, String intermDate) {
		super();
		this.accountName = accountName;
		this.intermReceiptCode = intermReceiptCode;
		this.airLoadCode = airLoadCode;
		this.railLoadCode = railLoadCode;
		this.roadLoadCode = roadLoadCode;
		this.airLoadDate = airLoadDate;
		this.railLoadDate = railLoadDate;
		this.roadLoadDate = roadLoadDate;
		this.intermDate = intermDate;
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		this.getDataFromBase();
		this.deleteFromDatabase();
		String content="'"+accountName+"','"+intermReceiptCode+"','"+airLoadCode+"','"
				+railLoadCode+"','"+roadLoadCode+"','"+airLoadDate+"','"+railLoadDate+"','"
				+roadLoadDate+"','"+intermDate+"'";
		writer.writeIntoSql("IntermediateReceipt", content);
	}
	
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("CourrierReceipt","�˻���",accountName);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("IntermediateReceipt");
		reader.findNext("�˻���",accountName);
		if(intermReceiptCode!=null)
			this.intermReceiptCode=reader.getString("��ת���յ�����")+" "+this.intermReceiptCode;
		else
			this.intermReceiptCode=reader.getString("��ת���յ�����");
		
		if(airLoadCode!=null)
			this.airLoadCode=reader.getString("�ɻ�װ�˵�����")+" "+this.airLoadCode;
		else
			this.airLoadCode=reader.getString("�ɻ�װ�˵�����");
		
		if(railLoadCode!=null)
			this.railLoadCode=reader.getString("��װ�˵�����")+" "+this.railLoadCode;
		else
			this.railLoadCode=reader.getString("��װ�˵�����");
		
		if(roadLoadCode!=null)
			this.roadLoadCode=reader.getString("����װ�˵�����")+" "+this.roadLoadCode;
		else
			this.roadLoadCode=reader.getString("����װ�˵�����");
		
		if(airLoadDate!=null)
			this.airLoadDate=reader.getString("�ɻ�װ�˵�����ʱ��")+" "+this.airLoadDate;
		else
			this.airLoadDate=reader.getString("�ɻ�װ�˵�����ʱ��");
		
		if(railLoadDate!=null)
			this.railLoadDate=reader.getString("��װ�˵�����ʱ��")+" "+this.railLoadDate;
		else
			this.railLoadDate=reader.getString("��װ�˵�����ʱ��");
		
		if(roadLoadDate!=null)
			this.roadLoadDate=reader.getString("����װ�˵�����ʱ��")+" "+this.roadLoadDate;
		else
			this.roadLoadDate=reader.getString("����װ�˵�����ʱ��");
		
		if(intermDate!=null)
			this.intermDate=reader.getString("��ת���յ�����ʱ��")+" "+this.intermDate;
		else
			this.intermDate=reader.getString("��ת���յ�����ʱ��");
	}
}
