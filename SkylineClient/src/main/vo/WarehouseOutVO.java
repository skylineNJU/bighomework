package main.vo;

import main.businesslogic.warehousebl.WarehouseOut;
import main.State.TransType;

public class WarehouseOutVO extends ReceiptVO{
	private String bar;
	private String code;
	private String destination;
	private TransType type;
	private String outDate;
	private String transferCode;
	private String vehicleCode;
	private String damageCondition;
	private String area;
	private int row;
	private int shelf;
	private int position;
	
	
	
	
	public WarehouseOutVO(String b,String co,String c,String k,TransType t,String d,String e,String f){
		super(co);//outdata
		bar=b;
		code=co;
		destination = c;
		outDate =k;
		type = t;
		transferCode = d;
		vehicleCode = e;
		damageCondition =f;
	}
	
	
	public WarehouseOutVO( String code, String area, int row,
			int shelf, int position) {
		super(code);
		this.code = code;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}


	public boolean writeWarehouseOutInfo(WarehouseOut who){
		this.code=who.getCode();
		this.bar = who.getBar();
		this.destination=who.getDestination();
		this.outDate = who.getOutDate();
		this.type=who.getTransType();
		this.transferCode=who.getTransferCode();
		this.vehicleCode=who.getVehicleCode();
		this.damageCondition=who.getDamageCondition();
		return true;
	}
	
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getShelf() {
		return shelf;
	}

	public void setShelf(int shelf) {
		this.shelf = shelf;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getCode() {
		return code;
	}

	public void setTransferCode(String transferCode) {
		this.transferCode = transferCode;
	}

	public String getDamageCondition() {
		return damageCondition;
	}

	public void setDamageCondition(String damageCondition) {
		this.damageCondition = damageCondition;
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
