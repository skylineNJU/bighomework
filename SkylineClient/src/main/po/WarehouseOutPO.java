package main.po;
import java.io.Serializable;

import main.State.*;
public class WarehouseOutPO extends Receipt implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
 * 快递编号、出库日期、目的地、装运形式（火车、飞机、汽车）、中转单编号或者汽运编号
 */
	
	String bar;
	String outDate;
	String destination;
	
	TransType type;
	String transferCode;
	String vehicleCode;
	public WarehouseOutPO(String a,String b,String c,TransType t,String d,String e){
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
