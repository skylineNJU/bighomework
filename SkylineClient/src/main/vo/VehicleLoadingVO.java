package main.vo;

public class VehicleLoadingVO extends ReceiptVO{
	private String loadingDate;//装运日期
	private String carNum;//中转中心汽运编号
	private String carTourNum;//车次号
	private String departure;//出发地
	private String destination;//到达地
	private String monitor;//监装员
	private String guard;//押送员
	private String shipment;//装箱托运区号
	private double freight;//运费
	private String belong;
	
	
	public VehicleLoadingVO(String co, String loadingDate, String carNum, String carTourNum, String departure,
			String destination, String monitor, String guard, String shipment, double freight) {
		super(co);
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

	public boolean writeVehicleLoadingInfo(VehicleLoadingVO vl){
		this.loadingDate=vl.getLoadingDate();
		this.carNum=vl.getCarNum();
		this.carTourNum=vl.getCarTourNum();
		this.departure=vl.getDeparture();
		this.destination=vl.getDestination();
		this.monitor=vl.getMonitor();
		this.guard=vl.getGuard();
		this.shipment=vl.getShipment();
		this.freight=vl.getFreight();
		return true;
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

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

}