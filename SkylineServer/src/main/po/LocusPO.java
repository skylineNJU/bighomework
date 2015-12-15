package main.po;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class LocusPO extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderCode;
	private int arriveLobby1=0;
	private int arriveInterm1=0;
	private int arriveInterm2=0;
	private int arriveLobby2=0;
	private int isReceived=0;
	private String beginCity="";
	private String endCity="";
	
	public LocusPO(String orderCode){
		this.orderCode=orderCode;
	}
	
	public LocusPO(String orderCode,String beginCity,String endCity){
		this.orderCode=orderCode;
		this.beginCity=beginCity;
		this.endCity=endCity;
	}
	
	public void writeIntoDataBase(){
		System.out.println("---------writing start------------");
		SqlWriter writer=new SqlWriter();
		arriveLobby1=1;
		String content="'"+orderCode+"',"+arriveLobby1+","+arriveInterm1+","
				+arriveInterm2+","+arriveLobby2+","+isReceived+",'"+beginCity+"','"+endCity+"'";
		writer.writeIntoSql("History", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("History");
		if(reader.findNext("������",orderCode)){
			this.arriveLobby1=reader.getInt("�Ƿ񵽴������Ӫҵ��");
			this.arriveInterm1=reader.getInt("�Ƿ񵽴��������ת����");
			this.arriveInterm2=reader.getInt("�Ƿ񵽴ﵽ�����ת����");
			this.arriveLobby2=reader.getInt("�Ƿ񵽴ﵽ���Ӫҵ��");
			this.isReceived=reader.getInt("�ռ����Ƿ��յ�����");
			this.beginCity=reader.getString("��������");
			this.endCity=reader.getString("�������");
		}
	}
	public void arriveLobby(){
		this.getDataFromBase();
		arriveLobby2=1;
		this.deleteFromDatabase();
		this.writeIntoDataBase();
	}
	public void arriveIntermedate(){
		this.getDataFromBase();
		if(this.arriveInterm1==0){
			arriveInterm1=1;
		}else{
			arriveInterm2=1;
		}
		this.deleteFromDatabase();
		this.writeIntoDataBase();
	}
	
	public void isReceived(){
		this.getDataFromBase();
		this.isReceived=1;
		this.deleteFromDatabase();
		this.writeIntoDataBase();
	}
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("History","������",orderCode);
	}
}
