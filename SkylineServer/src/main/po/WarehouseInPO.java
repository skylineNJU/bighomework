package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class WarehouseInPO extends Receipt implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bar;//订单号
	private String code;
	private String inDate;
	private String destination;
	private String area;
	private int row;
	private int shelf;
	private int position;
	private String damageCondition;

	
	public WarehouseInPO(String code, String area, int row, int shelf,int position) {
		super();
		this.code = code;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}


	public WarehouseInPO(String bar, String code,String inDate, String destination, String area, int row, int shelf, int position,
			String damageCondition) {
		super();
		this.code=code;
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
		if(hasCargo()){
			this.setKey("Can't build!!!");	
			}
		else{
			SqlWriter writer=new SqlWriter();
			String content="'"+bar+"','"+super.getCode()+"','"+destination+"','"+inDate+"','"
					+area+"',"+row+","+shelf+","+position+",'"+damageCondition+"'";
			writer.writeIntoSql("Warhousein", content);
			InventoryPO inven=new InventoryPO(bar,damageCondition,area,row,shelf, position,destination,inDate);
			inven.writeIntoDatabase();
			this.setKey("success");
		}
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
	
	public boolean hasCargo(){
		SqlReader reader=new SqlReader("InventoryInfo");
		if(reader.hasNext()){
			String a=reader.getString("区号");
			if(a.equals(area)&&reader.getString("排号").equals(row)
					&&reader.getString("架号").equals(shelf)&&reader.getString("位号").equals(position)){
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


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getInDate() {
		return inDate;
	}


	public void setInDate(String inDate) {
		this.inDate = inDate;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
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


	public String getDamageCondition() {
		return damageCondition;
	}


	public void setDamageCondition(String damageCondition) {
		this.damageCondition = damageCondition;
	}


	public String getBar() {
		return bar;
	}
	
	
	
	
	
	
	
	
}
