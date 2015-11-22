package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//中转中心接收单
public class CenterReceivePO extends Receipt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int receiveYear;//接收年份
	private int receiveMonth;//接收月份
	private int receiveDay;//接收天
	private String centerNumber;//中转中心编号
	private String bar;//快递的单号
	
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
		reader.findNext("中转中心接收单单号",this.getCode());
		String date[]=reader.getString("接收时间").split("/");
		receiveYear=Integer.parseInt(date[0]);
		receiveMonth=Integer.parseInt(date[1]);
		receiveDay=Integer.parseInt(date[2]);
		centerNumber=reader.getString("中转中心编号");
		bar=reader.getString("快递单号");
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
