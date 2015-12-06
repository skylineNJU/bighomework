package main.po;

import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//��ת���Ľ��յ�
public class CenterReceivePO extends Receipt implements Serializable{
	
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
	
	public String readOrderCode(String area){
		String content="";
		SqlReader reader=new SqlReader("InventoryInfo");
		while(reader.findNext("��ת���ı��",area)){
			content=content+reader.getString("��ת���ı��")+" ";
		}
		reader.close();
		return content;
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("TransReceive");
		if(reader.findNext("��ת���Ľ��յ�����",this.getCode())){String date[]=reader.getString("����ʱ��").split("/");
		receiveYear=Integer.parseInt(date[0]);
		receiveMonth=Integer.parseInt(date[1]);
		receiveDay=Integer.parseInt(date[2]);
		centerNumber=reader.getString("��ת���ı��");
		bar=reader.getString("��ݵ���");
		}
	
	}

	public int getReceiveYear() {
		return receiveYear;
	}

	public void setReceiveYear(int receiveYear) {
		this.receiveYear = receiveYear;
	}

	public int getReceiveMonth() {
		return receiveMonth;
	}

	public void setReceiveMonth(int receiveMonth) {
		this.receiveMonth = receiveMonth;
	}

	public int getReceiveDay() {
		return receiveDay;
	}

	public void setReceiveDay(int receiveDay) {
		this.receiveDay = receiveDay;
	}

	public String getCenterNumber() {
		return centerNumber;
	}

	public void setCenterNumber(String centerNumber) {
		this.centerNumber = centerNumber;
	}

	public String getBar() {
		return bar;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
