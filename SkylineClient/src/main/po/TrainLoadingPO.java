package main.po;
import java.io.Serializable;
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
	
	


	public TrainLoadingPO(String loadingDate, String trainNum, String trainTourNum, String departure,
			String destination, String monitor, String store, String shipment, double freight) {
		super();
		this.loadingDate = loadingDate;
		this.trainNum = trainNum;
		this.trainTourNum = trainTourNum;
		this.departure = departure;
		this.destination = destination;
		this.monitor = monitor;
		this.store = store;
		this.shipment = shipment;
		this.setFreight(freight);
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

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}


}
