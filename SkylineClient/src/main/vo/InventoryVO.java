package main.vo;

import main.businesslogic.warehousebl.Inventory;

public class InventoryVO {
	private int inNum;
 	private int outNum;
 	private String orderCode;
 	private String receiptType;
 	private String bar;
 	private String damageCondition;
 	private String area;
 	private String cityCode;
	private int row;
	private int shelf;
	private int position;
	private String destination;
	private String arriveDate;
	
	public InventoryVO( String orderCode, String arriveDate, String destination, String area, int row, int shelf, int position){
		super();
		this.orderCode = orderCode;
		this.arriveDate = arriveDate;
		this.destination = destination;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}
	
	public InventoryVO(String orderCode, String receiptType,String cityCode,
			String arriveDate,String destination, String area, int row, int shelf,
			int position, String damageCondition) {
		super();
		this.orderCode = orderCode;
		this.receiptType = receiptType;
		this.cityCode=cityCode;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
		this.destination = destination;
		this.arriveDate = arriveDate;
		this.damageCondition = damageCondition;
	}

	public InventoryVO(int a,int b,String c,String d,String e,int f,int g,int h,String i,String j){
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
	
	
	public String getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
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
