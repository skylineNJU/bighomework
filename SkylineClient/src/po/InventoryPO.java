package po;
import java.io.Serializable;

public class InventoryPO implements Serializable{
/*		
 * 出/入库数量，出入库货物的订单号，损坏情况，分区号排号架号位号，到达日期,目的地
 * 
*/
	 	int inNum;
	 	int outNum;
	 	String orderCode;
	 	String damageCondition;
	 	String area;
		int row;
		int shelf;
		int position;
		String destination;
		String arriveDate;
		
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
