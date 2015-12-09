package main.po;
import java.io.Serializable;

import main.State.TransType;
public class WarehouseOutPO extends Receipt implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
 * 快递编号、出库日期、目的地、装运形式（火车、飞机、汽车）、中转单编号或者汽运编号
 */
	
	private	String bar;
	private	String code;
	private	String outDate;
	private	String destination;
	private	TransType type;
	private	String transferCode;
	private	String vehicleCode;
	private	String damageCondition;
	private String area;
	private int row;
	private int shelf;
	private int position;
	
	public WarehouseOutPO(String code) {
		super();
		this.code = code;
	}
	public WarehouseOutPO(String code,String area,int row,int shelf,int position) {
		super();
		this.code = code;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}


	public WarehouseOutPO(String a,String co,String b,String c,TransType t,String d,String e,String f){
		bar=a;
		code=co;
		outDate =b;
		destination = c;
		type = t;
		transferCode = d;
		vehicleCode = e;
		damageCondition=f;
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


	public String getDamageCondition() {
		return damageCondition;
	}

	public void setDamageCondition(String damageCondition) {
		this.damageCondition = damageCondition;
	}

	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public TransType getTType() {
		return type;
	}
	public void setTType(TransType type) {
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
