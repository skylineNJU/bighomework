package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;
//车辆装车管理
public class LoadingInfoPO  extends Receipt implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loadingDate;//装车日期
	private String autoMobileNum;//营业厅汽运编号
	private String departure;//出发地
	private String destination;//到达地
	private String monitor;//监装员
	private String guard;//押送员
	private String shipment;//装箱托运区号
	double freight;//运费
	
	
	public void writeIntoDatabase(){
		shipment=readOrderCode(shipment);
		SqlWriter writer=new SqlWriter();
		String content="'"+super.getCode()+"','"+autoMobileNum+"','"+departure+"','"
				+destination+"','"+monitor+"','"+guard+"','"+shipment+"',"+freight;
		writer.writeIntoSql("LobbyLoading", content);
	}
	
	public String readOrderCode(String area){
		String content="";
		SqlReader reader=new SqlReader("InventoryInfo");
		while(reader.findNext("区号",area)){
			content=content+reader.getString("订单号")+" ";
		}
		reader.close();
		return content;
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("LobbyLoading");
		reader.findNext("营业厅装运单单号",this.getCode());
		this.autoMobileNum=reader.getString("汽车车次号");
		this.departure=reader.getString("出发地");
		this.destination=reader.getString("到达地");
		this.monitor=reader.getString("监装员");
		this.guard=reader.getString("押运员");
		this.shipment=reader.getString("所有货物订单号");
		this.freight=reader.getDouble("运费");
		reader.close();
	}
	
	public String getLoadingDate() {
		return loadingDate;
	}

	public void setLoadingDate(String loadingDate) {
		this.loadingDate = loadingDate;
	}

	public String getAutoMobileNum() {
		return autoMobileNum;
	}

	public void setAutoMobileNum(String autoMobileNum) {
		this.autoMobileNum = autoMobileNum;
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

	public String getGuard() {
		return guard;
	}

	public void setGuard(String guard) {
		this.guard = guard;
	}

	public String getShipment() {
		return shipment;
	}

	public void setShipment(String shipment) {
		this.shipment = shipment;
	}

}
