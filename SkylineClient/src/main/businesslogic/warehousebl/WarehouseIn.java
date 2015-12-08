package main.businesslogic.warehousebl;

import java.util.ArrayList;

import main.data.warehouse.WarehouseDataController;
import main.dataservice.WarehouseDataService;
import main.po.InventoryList;
import main.po.InventoryPO;
import main.po.WarehouseInList;
import main.po.WarehouseInPO;
import main.vo.InventoryVO;
import main.vo.WarehouseInVO;

public class WarehouseIn {
	private String bar;//������
	private String code;//��ⵥ���
	private String destination;//Ŀ�ĵ�
	private String inDate;//�������
	private String area;//���� ,
	private int row;//�ź�
	private int shelf;//�ܺ�
	private int position;//λ��
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
		if(inquire(code) != null){
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
	
	
	//����̵�
	public boolean check(){
		return true;
	}
	
	public boolean saveInfo(){
		po=new WarehouseInPO(this.bar,this.code,this.destination,this.inDate,this.area,this.row,this.shelf,this.position,this.damageCondition);
		po.setCode(code);
		WarehouseDataService service=new WarehouseDataController();
		boolean a=service.createWarehouseInReceipt(po);
		System.out.println("122222222222222222222:::::"+a);
		return a;	
	}
	
	public boolean modify(){
		return true;
	}
	
	public ArrayList<WarehouseInVO> inquire(String bar){
		WarehouseDataService service=new WarehouseDataController();
		po=new WarehouseInPO(bar);
		WarehouseInList WarehouseInlist=new WarehouseInList(bar);
		WarehouseInlist.add(po);
		WarehouseInlist=service.inquireWarehouseIn(WarehouseInlist);
		ArrayList<WarehouseInVO> warehouseInInfo=new ArrayList<WarehouseInVO>();
		for(WarehouseInPO p:WarehouseInlist.getlist()){
			System.out.println(p.getCode());
			 warehouseInInfo.add(new WarehouseInVO(p.getCode(),
									p.getArea(),
									p.getRow(),
									p.getShelf(),
									p.getPosition()
									));
		}
		return  warehouseInInfo;
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
