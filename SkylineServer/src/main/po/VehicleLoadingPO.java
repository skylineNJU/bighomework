package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;
public class VehicleLoadingPO  extends Receipt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loadingDate;//装运日期
	private String carNum;//中转中心汽运编号
	private String carTourNum;//车次号
	private String departure;//出发地
	private String destination;//到达地
	private String monitor;//监装员
	private String guard;//押送员
	private String shipment;//装箱托运区号
	private double freight;//运费
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		shipment=readOrderCode(shipment);
		String content="'"+this.getCode()+"','"+loadingDate+"','"+carNum+"','"
				+carTourNum+"','"+departure+"','"+destination+"','"+monitor+"','"
				+guard+"','"+shipment+"',"+freight;
		writer.writeIntoSql("VehicleLoading", content);
	}
	
	public String readOrderCode(String area){
		String content="";
		SqlReader reader=new SqlReader("InventoryInfo");
		String position[]=area.split("  ");
		while(reader.findNext("区号",position[0])){
			if(reader.getString("架号").equals(position[1]))
			content=content+reader.getString("订单号")+" ";
		}
		reader.close();
		return content;
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("VehicleLoading");
		reader.findNext("中转中心汽车装运单",this.getCode());
		this.loadingDate=reader.getString("装运日期");
		this.carNum=reader.getString("中转中心汽运编号");
		this.carTourNum=reader.getString("车次号");
		this.departure=reader.getString("出发地");
		this.destination=reader.getString("到达地");
		this.monitor=reader.getString("监装员");
		this.guard=reader.getString("押运员");
		this.shipment=reader.getString("所有订单单号");
		this.freight=reader.getDouble("运费");
	}
}
