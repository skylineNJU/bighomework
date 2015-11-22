package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class WarehouseInPO extends Receipt implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bar;
	private String inDate;
	private String destination;
	private String area;
	private int row;
	private int shelf;
	private int position;
	private String damageCondition;
	
	
	public WarehouseInPO(String bar, String inDate, String destination, String area, int row, int shelf, int position,
			String damageCondition) {
		super();
		this.bar = bar;
		this.inDate = inDate;
		this.destination = destination;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
		this.damageCondition = damageCondition;
	}


	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+bar+"','"+super.getCode()+"','"+destination+"','"+inDate+"','"
				+area+"',"+row+","+shelf+","+position+",'"+damageCondition+"'";
		writer.writeIntoSql("Warhousein", content);
		InventoryPO inven=new InventoryPO(bar,damageCondition,area,row,shelf, position,destination,inDate);
		inven.writeIntoDatabase();
		
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("WarhouseIn");
		reader.findNext("入库单单号",this.getCode());
		this.bar=reader.getString("订单单号");
		this.area=reader.getString("区号");
		this.damageCondition=reader.getString("损坏情况");
		this.destination=reader.getString("目的地");
		this.inDate=reader.getString("入库日期");
		this.row=reader.getInt("排号");
		this.shelf=reader.getInt("架号");
		this.position=reader.getInt("位号");
		reader.close();
	}
}
