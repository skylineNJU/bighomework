package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//��ת���Ľ��յ�
public class CenterReceivePO extends Receipt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int receiveYear;//�������
	private int receiveMonth;//�����·�
	private int receiveDay;//������
	private String centerNumber;//��ת���ı��
	private String bar;//��ݵĵ���
	
	public CenterReceivePO(int receiveYear,int receiveMonth,int receiveDay,String centerNumber,String bar){
		this.receiveYear = receiveYear;
		this.receiveMonth = receiveMonth;
		this.receiveDay = receiveDay;
		this.centerNumber = centerNumber;
		this.bar = bar;
	}

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+receiveYear+"/"+receiveMonth+"/"
				+receiveDay+"','"+centerNumber+"','"+bar+"','"+this.getCode()+"'";
		writer.writeIntoSql("TransReceive",content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("TransReceive");
		reader.findNext("��ת���Ľ��յ�����",this.getCode());
		String date[]=reader.getString("����ʱ��").split("/");
		receiveYear=Integer.parseInt(date[0]);
		receiveMonth=Integer.parseInt(date[1]);
		receiveDay=Integer.parseInt(date[2]);
		centerNumber=reader.getString("��ת���ı��");
		bar=reader.getString("��ݵ���");
	}
	
	public int getReceiveYear() {
		return receiveYear;
	}

	public int getReceiveMonth() {
		return receiveMonth;
	}

	public int getReceiveDay() {
		return receiveDay;
	}

	public String getCenterNumber() {
		return centerNumber;
	}

	public String getBar() {
		return bar;
	}

}
