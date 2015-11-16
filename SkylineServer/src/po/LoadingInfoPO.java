package po;
import java.io.Serializable;
//车辆装车管理
public class LoadingInfoPO  extends Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String loadingDate;//装车日期
	String autoMobileNum;//营业厅汽运编号
	String departure;//出发地
	String destination;//到达地
	String monitor;//监装员
	String guard;//押送员
	String shipment;//装箱托运区号
	String freight;//运费
	
	public LoadingInfoPO(String a,String b,String c,String d,String e,String f,String g,String h){
		loadingDate=a;
		 autoMobileNum=b;
		departure=c;
		destination=d;
		 monitor=e;
		 guard=f;
		shipment=g;//装箱托运区号
		freight=h;//运费
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

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}
	
}
