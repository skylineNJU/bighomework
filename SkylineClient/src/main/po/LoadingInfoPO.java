package main.po;
//车辆装车管理
public class LoadingInfoPO  extends Receipt{
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
	private double freight;//运费
	
	
	
	public LoadingInfoPO(String loadingDate, String autoMobileNum, String departure, String destination, String monitor,
			String guard, String shipment, double freight) {
		super();
		this.loadingDate = loadingDate;
		this.autoMobileNum = autoMobileNum;
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

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	
}
