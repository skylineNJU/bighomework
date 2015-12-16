package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;
public class TrainLoadingPO  extends Receipt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loadingDate;//装运日期
	private String trainNum;//中转中心货运编号
	private String trainTourNum;//车次号
	private String departure;//出发地
	private String destination;//到达地
	private String monitor;//监装员
	private String store;//车厢号
	private String shipment;//装箱托运区号
	private double freight;//运费
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		shipment=readOrderCode(shipment);
		String content="'"+trainNum+"','"+trainTourNum+"','"+store+"','"+departure+"','"
				+destination+"','"+monitor+"','"+shipment+"','"+super.getCode()+"',"+freight+",'"+loadingDate+"'";
		writer.writeIntoSql("TrainLoading", content);
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
		SqlReader reader=new SqlReader("TrainLoading");
		reader.findNext("火车装运单单号",this.getCode());
		this.departure=reader.getString("出发地");
		this.destination=reader.getString("到达地");
		this.trainTourNum=reader.getString("火车车次号");
		this.trainNum=reader.getString("中转中心火车货运编号编号");
		this.monitor=reader.getString("监装员");
		this.shipment=reader.getString("所有货物订单号");
		this.store=reader.getString("车厢号");
		this.loadingDate=reader.getString("单据生成时间");
		this.freight=reader.getDouble("运费");
		reader.close();
	}
	
	

	public String getLoadingDate() {
		return loadingDate;
	}

	public void setLoadingDate(String loadingDate) {
		this.loadingDate = loadingDate;
	}

	public String getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}

	public String getTrainTourNum() {
		return trainTourNum;
	}

	public void setTrainTourNum(String trainTourNum) {
		this.trainTourNum = trainTourNum;
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
