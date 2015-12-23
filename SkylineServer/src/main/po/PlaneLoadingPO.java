package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;
public class PlaneLoadingPO  extends Receipt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loadingDate;//装机日期
	private String flightNum;//中转中心航运编号
	private String planeNum;//航班号
	private String departure;//出发地
	private String destination;//到达地
	private String monitor;//监装员
	private String store;//货柜号
	private String shipment;//装箱托运区号
	private double freight;//运费
	

	

	public void writeIntoDatabase(){
		shipment=readOrderCode(shipment);
		SqlWriter writer=new SqlWriter();
		String content="'"+super.getCode()+"','"+flightNum+"','"+planeNum+"','"+departure+"','"
				+destination+"','"+store+"','"+monitor+"','"+shipment+"',"+freight+",'"+loadingDate+"'";
		writer.writeIntoSql("PlaneLoading", content);
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
		SqlReader reader=new SqlReader("PlaneLoading");
		if(reader.findNext("飞机装运单单号",this.getCode())){
		this.flightNum=reader.getString("中转中心编号");
		this.planeNum=reader.getString("飞机航班号");
		this.departure=reader.getString("出发地");
		this.destination=reader.getString("到达地");
		this.store=reader.getString("飞机舱号");
		this.monitor=reader.getString("监装员");
		this.freight=reader.getDouble("运费");
		this.loadingDate=reader.getString("单据生成时间");
		this.shipment=reader.getString("所有的订单号");
		}
		reader.close();
	}
	public String getLoadingDate() {
		return loadingDate;
	}

	public void setLoadingDate(String loadingDate) {
		this.loadingDate = loadingDate;
	}

	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public String getPlaneNum() {
		return planeNum;
	}

	public void setPlaneNum(String planeNum) {
		this.planeNum = planeNum;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getShipment() {
		return shipment;
	}

	public void setShipment(String shipment) {
		this.shipment = shipment;
	}

}
