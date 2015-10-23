package po;
import java.io.Serializable;
public class VehicleLoadingPO  implements Serializable{
	String loadingDate;//装运日期
	String carNum;//中转中心汽运编号
	String carTourNum;//车次号
	String departure;//出发地
	String destination;//到达地
	String monitor;//监装员
	String guard;//押送员
	String shipment;//装箱托运区号
	String freight;//运费
	
	public VehicleLoadingPO(String a,String b,String c,String d,String e,String f,String g,String h,String i){
		loadingDate=a;
		carNum=b;
		carTourNum=c;
		departure=d;
		destination=e;
		monitor=f;
		guard=g;
		shipment=h;
		freight=i;
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

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}
}
