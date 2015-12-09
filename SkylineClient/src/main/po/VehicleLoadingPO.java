package main.po;
import java.io.Serializable;
public class VehicleLoadingPO  extends Receipt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String loadingDate;//装运日期
	String carNum;//中转中心汽运编号
	String carTourNum;//车次号
	String departure;//出发地
	String destination;//到达地
	String monitor;//监装员
	String guard;//押送员
	String shipment;//装箱托运区号
	double freight;//运费
	
	
	public VehicleLoadingPO(String loadingDate, String carNum,
			String carTourNum, String departure, String destination,
			String monitor, String guard, String shipment, double freight) {
		super();
		this.loadingDate = loadingDate;
		this.carNum = carNum;
		this.carTourNum = carTourNum;
		this.departure = departure;
		this.destination = destination;
		this.monitor = monitor;
		this.guard = guard;
		this.shipment = shipment;
		this.freight = freight;
	}

	public String getLoadingDate() {
		return loadingDate;
	}

	public void setLoadingDate(String loadingDate) {
		this.loadingDate = loadingDate;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getCarTourNum() {
		return carTourNum;
	}

	public void setCarTourNum(String carTourNum) {
		this.carTourNum = carTourNum;
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

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}
}
