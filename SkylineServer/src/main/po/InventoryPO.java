package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class InventoryPO extends Message implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 	private String orderCode;
	 	private String bar;
	 	private String damageCondition;
	 	private String area;
		private int row;
		private int shelf;
		private int position;
		private String destination;
		private String arriveDate;
		
		public InventoryPO( String orderCode, String arriveDate, String destination, String area, int row, int shelf, int position){
			super();
			this.orderCode = orderCode;
			this.arriveDate = arriveDate;
			this.destination = destination;
			this.area = area;
			this.row = row;
			this.shelf = shelf;
			this.position = position;
		}

		
		public InventoryPO(String c,String d,String e,int f,int g,int h,String i,String j){
			orderCode=c;
			damageCondition=d;
			area=e;
			row=f;
			shelf=g;
			position=h;
			destination=i;
			arriveDate=j;
		}

		public void writeIntoDatabase(){
			SqlWriter writer=new SqlWriter();
			String content="'"+orderCode+"','"+damageCondition+"','"+area+"',"+
			row+","+shelf+","+position+",'"+destination+"','"+arriveDate+"'";
			writer.writeIntoSql("InventoryInfo", content);
		}
		
		public void getDaraFromBase(){
			SqlReader reader=new SqlReader("InventoryInfo");
			reader.findNext("区号",area);
			this.damageCondition=reader.getString("损坏情况");
			this.area=reader.getString("区号");
			this.arriveDate=reader.getString("入库时间");
			this.destination=reader.getString("目的地");
			this.row=reader.getInt("排号");
			this.shelf=reader.getInt("架号");
			this.position=reader.getInt("位号");
			reader.close();
		}
	
		public String getOrderCode() {
			return orderCode;
		}

		public String getDamageCondition() {
			return damageCondition;
		}

		public String getArea() {
			return area;
		}

		public int getRow() {
			return row;
		}

		public int getShelf() {
			return shelf;
		}

		public int getPosition() {
			return position;
		}

		public String getDestination() {
			return destination;
		}

		public String getArriveDate() {
			return arriveDate;
		}
}
