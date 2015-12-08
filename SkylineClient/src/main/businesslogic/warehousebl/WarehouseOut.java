package main.businesslogic.warehousebl;


import java.util.ArrayList;

import main.State.TransType;
import main.data.warehouse.WarehouseDataController;
import main.dataservice.WarehouseDataService;
import main.po.WarehouseInList;
import main.po.WarehouseInPO;
import main.po.WarehouseOutList;
import main.po.WarehouseOutPO;
import main.vo.WarehouseInVO;
import main.vo.WarehouseOutVO;

public class WarehouseOut {
	private String bar;
	private String code;
	private String destination;
	private TransType type;
	private String outDate;
	private String transferCode;
	private String vehicleCode;
	private String damageCondition;
	private String area;
	private int row;
	private int shelf;
	private int position;
	private WarehouseOutPO po;
	
	public WarehouseOut(WarehouseOutVO who){
		this.code=who.getCode();
		this.bar=who.getBar();
		this.destination=who.getDestination();
		this.outDate = who.getOutDate();
		this.type=who.getTransType();
		this.transferCode=who.getTransferCode();
		this.vehicleCode=who.getVehicleCode();
		this.damageCondition = who.getDamageCondition();
		this.area=who.getArea();
		this.row=who.getRow();
		this.position=who.getPosition();
		this.shelf=who.getShelf();
	}
	
	public WarehouseOut(){
		
	}
	
	public String getCode() {
		return code;
	}

	public String getDamageCondition() {
		return damageCondition;
	}

	public void setDamageCondition(String damageCondition) {
		this.damageCondition = damageCondition;
	}

	public boolean saveInfo(){
		po=new WarehouseOutPO(this.bar,this.code,this.outDate,this.destination,this.type,this.transferCode,this.vehicleCode,this.damageCondition);
		po.setCode(code);
		WarehouseDataService service=new WarehouseDataController();	
		return service.createWarehouseOutReceipt(po);
	
	}
	
	public boolean modify(){
		return true;
	}
	
	public ArrayList<WarehouseOutVO> inquire(String code){
		WarehouseDataService service=new WarehouseDataController();
		WarehouseOutList WarehouseOutlist=new WarehouseOutList(code);
		System.out.println("Size+++++++++++:::::::::::"+WarehouseOutlist.getlist().size());
		WarehouseOutlist=service.inquireWarehouseOut(WarehouseOutlist);
		ArrayList<WarehouseOutVO> warehouseOutInfo=new ArrayList<WarehouseOutVO>();
		for(WarehouseOutPO p:WarehouseOutlist.getlist()){
			System.out.println(p.getCode());
			 warehouseOutInfo.add(new WarehouseOutVO(p.getCode(),
									p.getArea(),
									p.getRow(),
									p.getShelf(),
									p.getPosition()
									));
		}
		return  warehouseOutInfo;
	}
	
		
	public static boolean delete(String Code){
		return true;
	}
	public String getOutDate() {
		return outDate;
	}


	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public TransType getTransType() {
		return type;
	}
	public void setTransType(TransType type) {
		this.type = type;
	}
	public String getVehicleCode() {
		return vehicleCode;
	}
	public void setVehicleCode(String vehicleCode) {
		this.vehicleCode = vehicleCode;
	}
	public String getTransferCode() {
		return transferCode;
	}

	public String getBar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
