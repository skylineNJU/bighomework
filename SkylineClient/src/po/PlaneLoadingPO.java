package po;
import java.io.Serializable;
public class PlaneLoadingPO  implements Serializable{
	String loadingDate;//装机日期
	String flightNum;//中转中心航运编号
	String planeNum;//航班号
	String departure;//出发地
	String destination;//到达地
	String monitor;//监装员
	String store;//货柜号
	String shipment;//装箱托运区号
	String freight;//运费
	
	public PlaneLoadingPO(String a,String b,String c,String d,String e,String f,String g,String h,String i){
		loadingDate=a;
		flightNum=b;
		planeNum=c;
		departure=d;
		destination=e;
		monitor=f;
		store=g;
		shipment=h;
		freight=i;
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

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}
}
