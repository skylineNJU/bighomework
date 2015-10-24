package po;
import java.io.Serializable;

public class WarehouseInPO implements Serializable{
/*
 * 快递编号、入库日期、目的地、区号、排号、架号、位号
 */
	String bar;
	String inDate;
	String destination;
	String area;
	int row;
	int shelf;
	int position;
	
	public WarehouseInPO(String a,String b,String c,String d,int e,int f,int g){
		bar = a;
		inDate = b;
		destination = c;
		area = d;
		row = e;
		shelf = f;
		position = g;
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

	public String getBar() {
		return bar;
	}

	public String getInDate() {
		return inDate;
	}
	
	
}
