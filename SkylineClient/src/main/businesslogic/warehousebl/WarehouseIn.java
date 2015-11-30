package main.businesslogic.warehousebl;

import main.data.warehouse.WarehouseDataController;
import main.dataservice.WarehouseDataService;
import main.po.WarehouseInPO;
import main.vo.WarehouseInVO;

public class WarehouseIn {
	private String bar;//订单号
	private String code;//入库单编号
	private String destination;//目的地
	private String inDate;//入库日期
	private String area;//区号 ,
	private int row;//排号
	private int shelf;//架号
	private int position;//位号
	private String damageCondition;
	private WarehouseInPO po;

	
	public WarehouseIn(WarehouseInVO whi){
		this.code =whi.getCode();
		this.bar=whi.getBar();
		this.destination=whi.getDestination();
		this.inDate=whi.getInDate();
		this.area=whi.getArea();
		this.row=whi.getRow();
		this.shelf=whi.getShelf();
		this.position=whi.getPosition();
		this.damageCondition =whi.getDamageCondition();
	}
	public WarehouseIn(String code){
		if(inquire(code)){
		this.bar=po.getBar();
		this.destination=po.getDestination();
		this.inDate=po.getInDate();
		this.area=po.getArea();
		this.row=po.getRow();
		this.shelf=po.getShelf();
		this.position=po.getPosition();
		this.damageCondition=po.getDamageCondition();
		}
	}
	
	
	//库存盘点
	public boolean check(){
		return true;
	}
	
	public boolean saveInfo(){
		po=new WarehouseInPO(this.bar,this.code,this.destination,this.inDate,this.area,this.row,this.shelf,this.position,this.damageCondition);
		po.setCode(code);
		WarehouseDataService service=new WarehouseDataController();
		service.createWarehouseInReceipt(po);	
		return true;
	}
	
	public boolean modify(){
		return true;
	}
	
	private boolean inquire(String Code){
		return true;	
	}
		
	public static boolean delete(String Code){
		return true;
	}

	
	public String getCode() {
		return code;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public void setDamageCondition(String damageCondition) {
		this.damageCondition = damageCondition;
	}
	public String getInDate() {
		return inDate;
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
	public String getDamageCondition() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
