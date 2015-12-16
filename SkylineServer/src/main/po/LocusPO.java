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
		if(reader.findNext("订单号",orderCode)){
			this.arriveLobby1=reader.getInt("是否到达出发地营业厅");
			this.arriveInterm1=reader.getInt("是否到达出发地中转中心");
			this.arriveInterm2=reader.getInt("是否到达到达地中转中心");
			this.arriveLobby2=reader.getInt("是否到达到达地营业厅");
			this.isReceived=reader.getInt("收件人是否收到货物");
			this.beginCity=reader.getString("出发城市");
			this.endCity=reader.getString("到达城市");
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
		deleter.deleteData("History","订单号",orderCode);
	}
}
