package main.vo;

import main.businesslogic.warehousebl.WarehouseOut;
import main.State.TransType;

public class WarehouseOutVO extends ReceiptVO{
	private String bar;
	private String destination;
	private TransType type;
	private String outDate;
	private String transferCode;
	private String vehicleCode;
	
	public WarehouseOutVO(String id, String da, String co,String b,String c,String k,TransType t,String d,String e){
		super(id, da, co);//outdata
		bar=b;
		destination = c;
		outDate =k;
		type = t;
		transferCode = d;
		vehicleCode = e;
	}
	
	public boolean writeWarehouseOutInfo(WarehouseOut who){
		this.bar = who.getBar();
		this.destination=who.getDestination();
		this.outDate = who.getOutDate();
		this.type=who.getTransType();
		this.transferCode=who.getTransferCode();
		this.vehicleCode=who.getVehicleCode();
		return true;
	}
	
	public String getBar() {
		return bar;
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
