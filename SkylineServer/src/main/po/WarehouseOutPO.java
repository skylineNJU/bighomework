package main.po;
import java.io.Serializable;

import main.State.TransType;
import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class WarehouseOutPO extends Receipt implements Serializable{

	private static final long serialVersionUID = 1L;
/*
 * 快递编号、出库日期、目的地、装运形式（火车、飞机、汽车）、中转单编号或者汽运编号
 */
	
	private String bar;
	private String code;
	private String outDate;
	private String destination;
	private TransType type;
	private String transferCode;
	private String vehicleCode;
	private String damageCondition;
	private String area;
	private int row;
	private int shelf;
	private int position;
	
	public WarehouseOutPO(String code,String area,int row,int shelf,int position) {
		super();
		this.code = code;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}
	public WarehouseOutPO(String bar, String code,String outDate, String destination, TransType type, String transferCode,
			String vehicleCode,	String damageCondition) {
		super();
		this.bar = bar;
		this.code=code;
		this.outDate = outDate;
		this.destination = destination;
		this.type = type;
		this.transferCode = transferCode;
		this.vehicleCode = vehicleCode;
		this.damageCondition=damageCondition;
	}
	
	
	public void writeIntoDatabase(){
		if(hasCargo()){
		
			SqlWriter writer=new SqlWriter();
			String content="'"+transferCode+"','"+type.name()+"','"+outDate+"','"
					+bar+"','"+vehicleCode+"','"+destination+"','"+super.getCode()+"','"+damageCondition+"'";
			writer.writeIntoSql("WarhouseOut", content);
			SqlDeleter delete=new SqlDeleter();
			delete.deleteData("InventoryInfo", "订单号", bar);
			this.setKey("success");
		}
		else{
			
			this.setKey("Can't build!!!");
		}
	}
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("WarhouseOut");
		if(reader.findNext("出库单单号",this.getCode())){
			this.bar = reader.getString("订单单号");
			this.transferCode = reader.getString("中转中心编号");
			this.outDate = reader.getString("出库时间");
			this.vehicleCode = reader.getString("运输工具编号");
			this.type = TransType.valueOf(reader.getString("装运形式"));
			this.destination = reader.getString("目的地");
			this.damageCondition = reader.getString("损坏情况");
			reader.close();
		
	
			SqlReader reader1 = new SqlReader("WarhouseIn");
			if(reader1.findNext("订单单号",this.getBar())){
			this.area = reader1.getString("区号");
			this.row = reader1.getInt("排号");
			this.shelf = reader1.getInt("架号");
			this.position = reader1.getInt("位号");
			}
			reader1.close();
		
		}
		
	}
	
	public boolean hasCargo(){
		SqlReader reader=new SqlReader("InventoryInfo");
		if(reader.findNext("订单号", this.getBar())){
			System.out.println("++++++++++++++!!!!!!!!!!!!!!!!!"+transferCode);
			if(reader.getString("区号").split(" ")[0].equals(transferCode)){
				return true;
			}
			else{
				reader.close();
				return false;
			}
		}
		else{
			reader.close();
			return false;
		}
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
