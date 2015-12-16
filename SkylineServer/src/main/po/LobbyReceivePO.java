package main.po;

import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//营业厅收到快递后生产的一条收件单信息
public class LobbyReceivePO extends Receipt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String receiveYear;//营业厅接收时间 
	private String receiveMonth;//营业厅接收时间 
	private String receiveDay;//营业厅接收时间 
	private String condition;//货物到达状态
	private String expressBar;//expressBar表示订单
	

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+receiveYear+"/"+receiveMonth+"/"+receiveDay+"','"
				+condition+"','"+expressBar+"','"+this.getCode()+"'";
		writer.writeIntoSql("LobbyReceive",content);
		LocusPO po=new LocusPO(this.expressBar);
		po.arriveLobby();
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("LobbyReceive");
		if(reader.findNext("单据号",this.getCode())){
		String date[]=reader.getString("接收时间").split("/");
		this.receiveYear=date[0];
		this.receiveMonth=date[1];
		this.receiveDay=date[2];
		condition=reader.getString("货物到达状态");
	    this.expressBar=reader.getString("订单号");
		}
	}
	
	
	
}
