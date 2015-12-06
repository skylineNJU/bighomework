package main.businesslogic.warehousebl;

import java.util.ArrayList;

import main.data.info.InfoDataController;
import main.data.warehouse.WarehouseDataController;
import main.dataservice.InfoDataService;
import main.dataservice.WarehouseDataService;
import main.po.DriverInfoPO;
import main.po.DriverList;
import main.po.InventoryList;
import main.po.InventoryPO;
import main.vo.DriverVO;
import main.vo.InventoryVO;

public class Inventory {
	private	int inNum;
	private	int outNum;
	private	String orderCode;
	private	String damageCondition;
	private	String area;
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
		if(inquire(Code) != null){
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
	
	public ArrayList<InventoryVO> inquire(String Code){
		WarehouseDataService service=new WarehouseDataController();
		po=new InventoryPO(Code);
		InventoryList Inventorylist=new InventoryList();
		Inventorylist.add(po);
		Inventorylist=service.inquireInventory(Inventorylist);
		ArrayList<InventoryVO> inventoryinfo=new ArrayList<InventoryVO>();
		for(InventoryPO p:Inventorylist.getlist()){
			System.out.println(p.getOrderCode());
			inventoryinfo.add(new InventoryVO(p.getOrderCode(),
									p.getArriveDate(),
									p.getDestination(),
									p.getArea(),
									p.getRow(),
									p.getShelf(),
									p.getPosition()
									));
		}
		return inventoryinfo;
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
