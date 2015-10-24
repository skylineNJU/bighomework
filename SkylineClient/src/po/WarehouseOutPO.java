package po;
import java.io.Serializable;

public class WarehouseOutPO implements Serializable{
/*
 * 快�?�编号�?�出库日期�?�目的地、装运形式（火车、飞机�?�汽车）、中转单编号或�?�汽运编�?
 */
	
	String bar;
	String outDate;
	String destination;
	
	public enum Type{
		train,plane,bus;
	}
	
	Type type;
	String transferCode;
	String vehicleCode;
	public WarehouseOutPO(String a,String b,String c,Type t,String d,String e){
		bar=a;
		outDate =b;
		destination = c;
		type = t;
		transferCode = d;
		vehicleCode = e;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getVehicleCode() {
		return vehicleCode;
	}
	public void setVehicleCode(String vehicleCode) {
		this.vehicleCode = vehicleCode;
	}
	public String getBar() {
		return bar;
	}
	public String getOutDate() {
		return outDate;
	}
	public String getTransferCode() {
		return transferCode;
	}
	
}
