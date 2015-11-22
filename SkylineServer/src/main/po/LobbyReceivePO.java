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
	private int receiveYear;//营业厅接收时间 
	private int receiveMonth;//营业厅接收时间 
	private int receiveDay;//营业厅接收时间 
	private int condition;//货物到达状态
	private String expressBar;//expressBar表示订单
	

	public void writerIntoDataBase(){
		SqlWriter writer=new SqlWriter();
		String cond = null;
		switch(condition){
		case 0:
			cond="完好";
			break;
		case 1:
			cond="破损";
			break;
		case 2:
			cond="丢失";
			break;
		}
		String content="'"+receiveYear+"/"+receiveMonth+"/"+receiveDay+"','"
				+cond+"','"+expressBar+"','"+this.getCode()+"'";
		writer.writeIntoSql("LobbyReceive",content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("LobbyReceive");
		reader.findNext("单据号",this.getCode());
		String date[]=reader.getString("接收时间").split(" ");
		this.receiveYear=Integer.parseInt(date[0]);
		this.receiveMonth=Integer.parseInt(date[1]);
		this.receiveDay=Integer.parseInt(date[2]);
		String condition=reader.getString("货物到达状态");
		switch(condition){
		case "完好":
			this.condition=0;
		case "破损":
			this.condition=1;
		case "丢失":
			this.condition=2;
		}
		this.expressBar=reader.getString("订单号");
	}
	
	
	
}
