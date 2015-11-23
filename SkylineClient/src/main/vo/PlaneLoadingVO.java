package main.vo;

public class PlaneLoadingVO {
	private String loadingDate;//装运日期
	private String flightNum;//中转中心
	private String planeNum;//
	private String departure;//出发地
	private String destination;//到达地
	private String monitor;//监装员
	private String store;//押送员
	private String shipment;//装箱托运区号
	private double freight;//运费

	public PlaneLoadingVO(String id, String da, String co, String a, String b, String c, String d,
			String e, String f,String g,String h, double i) {
		super();
		this.loadingDate=a;
		this.flightNum=b;
		this.planeNum=c;
		this.departure=d;
		this.destination=e;
		this.monitor=f;
		this.store=g;
		this.shipment=h;
		this.freight=i;
		// TODO Auto-generated constructor stub
	}
	
	public boolean writePlaneLoadingVOInfo(PlaneLoadingVO vl){
		this.loadingDate=vl.getLoadingDate();
		this.flightNum=vl.getCarNum();
		this.planeNum=vl.getCarTourNum();
		this.departure=vl.getDeparture();
		this.destination=vl.getDestination();
		this.monitor=vl.getMonitor();
		this.store=vl.getGuard();
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
		return flightNum;
	}

	public void setCarNum(String carNum) {
		this.flightNum = carNum;
	}

	public String getCarTourNum() {
		return planeNum;
	}

	public void setCarTourNum(String carTourNum) {
		this.planeNum = carTourNum;
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
		return store;
	}

	public void setGuard(String guard) {
		this.store = guard;
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
