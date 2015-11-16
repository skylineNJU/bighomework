package main.po;
import java.io.Serializable;

public class InventoryPO extends Message implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*	椋╋拷	
 * 閸戯拷/閸忋儱绨遍弫浼村櫤閿涘苯鍤崗銉ョ氨鐠愌呭⒖閻ㄥ嫯顓归崡鏇炲娇閿涘本宕崸蹇斿剰閸愮绱濋崚鍡楀隘閸欓攱甯撻崣閿嬬仸閸欒渹缍呴崣鍑ょ礉閸掓媽鎻弮銉︽埂,閻╊喚娈戦崷锟�
 * 
*/
	 	int inNum;
	 	int outNum;
	 	String orderCode;
	 	String damageCondition;
	 	char area;
		int row;
		int shelf;
		int position;
		String destination;
		String arriveDate;
		
		public InventoryPO(int a,int b,String c,String d,char e,int f,int g,int h,String i,String j){
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

		public char getArea() {
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
