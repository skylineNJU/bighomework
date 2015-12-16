package main.po;
import java.io.Serializable;

public class InventoryPO extends Message implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 	private	int inNum;
	 	private int outNum;
	 	private String bar;
	 	private String orderCode;
	 	private String damageCondition;
	 	private String area;
		private int row;
		private int shelf;
		private int position;
		private String destination;
		private String arriveDate;
		

		public InventoryPO(String area) {
			super();
			this.area = area;
		}

		public InventoryPO( String orderCode, String arriveDate, String destination, String area, int row, int shelf, int position){
		
			this.orderCode = orderCode;
			this.arriveDate = arriveDate;
			this.destination = destination;
			this.area = area;
			this.row = row;
			this.shelf = shelf;
			this.position = position;
		}
		
		
		public InventoryPO(int a,int b,String c,String d,String e,int f,int g,int h,String i,String j){
			inNum=a;
			outNum=b;
			orderCode=c;
			damageCondition=d;
			area=e;
			row=f;
			shelf=g;
			position=h;
			destination=i;
			arriveDate=j;
		}

		public int getInNum() {
			return inNum;
		}

		public int getOutNum() {
			return outNum;
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
