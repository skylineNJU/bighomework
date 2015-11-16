package businesslogic.warehousebl;

import po.InventoryPO;
import vo.InventoryVO;

public class Inventory {
	private	int inNum;
	private	int outNum;
	private	String orderCode;
	private	String damageCondition;
	private	char area;
	private	int row;
	private	int shelf;
	private	int position;
	private	String destination;
	private	String arriveDate;
	private InventoryPO po;

	public Inventory(InventoryVO vo){
		this.inNum=vo.getInNum();
		this.outNum=vo.getOutNum();
		this.orderCode=vo.getOrderCode();
		this.damageCondition=vo.getDamageCondition();
		this.area=vo.getArea();
		this.row=vo.getRow();
		this.shelf=vo.getShelf();
		this.position=vo.getPosition();
		this.destination=vo.getDestination();
		this.arriveDate=vo.getArriveDate();
	}
	
	public Inventory(String Code){
		if(inquire(Code)){
			this.inNum=po.getInNum();
			this.outNum=po.getOutNum();
			this.orderCode=po.getOrderCode();
			this.damageCondition=po.getDamageCondition();
			this.area=po.getArea();
			this.row=po.getRow();
			this.shelf=po.getShelf();
			this.position=po.getPosition();
			this.destination=po.getDestination();
			this.arriveDate=po.getArriveDate();
		}
	}
	
	public boolean show(){
		return true;
	}
	
	public boolean saveInfo(){
		return true;
	}
	
	public boolean modify(){
		return true;
	}
	private boolean inquire(String driverCode){
		
		return true;
		
	}
	
	public static boolean delete(String driverCode){
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
