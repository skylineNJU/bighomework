package vo;

public class WarehouseOutVO extends ReceiptVO{

	String destination;
	
	public enum Type{
		train,plane,bus;
	}
	
	Type type;
	String transferCode;
	String vehicleCode;
	public WarehouseOutVO(String id, String da, String co,String c,Type t,String d,String e){
		super(id, da, co);//outdata
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
	public String getTransferCode() {
		return transferCode;
	}
	
}
