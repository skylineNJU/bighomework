package main.po;
import java.io.Serializable;

public class WarehouseInPO extends Receipt implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
 * 入库单及入库信息
 */
	private String bar;//订单号
	private String code;//入库单号
	private String date;
	private String inDate;
	private String destination;
	private String area;
	private int row;
	private int shelf;
	private int position;
	private String damageCondition;
	
	
	
	public WarehouseInPO(String code){
		super();
		this.code=code;
	}

	public WarehouseInPO(String code, String area, int row, int shelf,int position) {
		super();
		this.code = code;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}

	public WarehouseInPO(String a,String co,String b,String c,String d,int e,int f,int g,String h){
		bar = a;
		code = co;
		inDate = b;
		destination = c;
		area = d;
		row = e;
		shelf = f;
		position = g;
		damageCondition=h;
	}

	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getCode() {
		return code;
	}


	public void setInDate(String inDate) {
		this.inDate = inDate;
	}


	public String getDamageCondition() {
		return damageCondition;
	}

	public void setDamageCondition(String damageCondition) {
		this.damageCondition = damageCondition;
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
