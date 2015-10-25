package vo;

public class InventoryVO {
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
	
	public InventoryVO(int a,int b,String c,String d,char e,int f,int g,int h,String i,String j){
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
