package main.businesslogic.warehousebl;


import main.State.TransType;
import main.po.WarehouseOutPO;
import main.vo.WarehouseOutVO;

public class WarehouseOut {
	private String destination;
	private TransType type;
	private String outDate;
	private String transferCode;
	private String vehicleCode;
	private WarehouseOutPO po;
	
	public WarehouseOut(WarehouseOutVO who){
		this.destination=who.getDestination();
		this.outDate = who.getOutDate();
		this.type=who.getTransType();
		this.transferCode=who.getTransferCode();
		this.vehicleCode=who.getVehicleCode();
	}
	
	public WarehouseOut(String code){
		if(inquire(code)){
		this.destination=po.getDestination();
		this.outDate = po.getOutDate();
		this.type=po.getTType();
		this.transferCode=po.getTransferCode();
		this.vehicleCode=po.getVehicleCode();
		}
	}
	
	public boolean saveInfo(){
		return true;
	}
	
	public boolean modify(){
		return true;
	}
	
	private boolean inquire(String Code){
		return true;	
	}
		
	public static boolean delete(String Code){
		return true;
	}
	public String getOutDate() {
		return outDate;
	}


	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}


	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public TransType getTransType() {
		return type;
	}
	public void setTransType(TransType type) {
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