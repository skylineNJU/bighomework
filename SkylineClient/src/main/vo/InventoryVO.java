package main.vo;

import main.businesslogic.infobl.Driver;
import main.businesslogic.warehousebl.Inventory;

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
	
	
	public boolean writeInentoryInfo(Inventory it){
		this.inNum=it.getInNum();
		this.outNum=it.getOutNum();
		this.orderCode=it.getOrderCode();
		this.damageCondition=it.getDamageCondition();
		this.area=it.getArea();
		this.row=it.getRow();
		this.shelf=it.getShelf();
		this.position=it.getPosition();
		this.destination=it.getDestination();
		this.arriveDate=it.getArriveDate();
		return true;
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
