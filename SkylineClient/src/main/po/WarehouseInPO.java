package main.po;
import java.io.Serializable;

public class WarehouseInPO extends Receipt implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
 * 蹇�掔紪鍙枫�佸叆搴撴棩鏈熴�佺洰鐨勫湴銆佸尯鍙枫�佹帓鍙枫�佹灦鍙枫�佷綅鍙�
 */
	String bar;
	String inDate;
	String destination;
	char area;
	int row;
	int shelf;
	int position;
	
	public WarehouseInPO(String a,String b,String c,char d,int e,int f,int g){
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

	public char getArea() {
		return area;
	}

	public void setArea(char area) {
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
