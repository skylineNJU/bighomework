package main.po;
import java.io.Serializable;

import main.State.TransType;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class WarehouseOutPO extends Receipt implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
 * 快递编号、出库日期、目的地、装运形式（火车、飞机、汽车）、中转单编号或者汽运编号
 */
	
	private String bar;
	private String outDate;
	private String destination;
	private TransType type;
	private String transferCode;
	private String vehicleCode;
	private String damageCondition;
	
	
	public WarehouseOutPO(String bar, String outDate, String destination, TransType type, String transferCode,
			String vehicleCode,String damageCondition) {
		super();
		this.bar = bar;
		this.outDate = outDate;
		this.destination = destination;
		this.type = type;
		this.transferCode = transferCode;
		this.vehicleCode = vehicleCode;
		this.damageCondition=damageCondition;
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+transferCode+"','"+type.name()+"','"+outDate+"','"
				+bar+"','"+vehicleCode+"','"+destination+"','"+super.getCode()+"'";
		writer.writeIntoSql("WarhouseOut", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("WarhouseOut");
		reader.findNext("出库单单号",this.getCode());
		this.bar=reader.getString("订单单号");
		this.transferCode=reader.getString("中转中心编号");
		this.outDate=reader.getString("出库时间");
		this.vehicleCode=reader.getString("运输工具编号");
		this.type=TransType.valueOf(reader.getString("装运形式"));
		this.destination=reader.getString("目的地");
		this.damageCondition=reader.getString("损坏情况");
		reader.close();
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
