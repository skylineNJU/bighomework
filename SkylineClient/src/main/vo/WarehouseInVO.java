package main.vo;

import main.businesslogic.warehousebl.WarehouseIn;


public class WarehouseInVO extends ReceiptVO{

// TODO Auto-generated constructor stub
	private String bar;//������
	private String code;//��ⵥ���
	private String destination;//Ŀ�ĵ�
	private String inDate;//�������
	private String area;//����
	private int row;//�ź�
	private int shelf;//�ܺ�
	private int position;//λ��
	private String damageCondition;
	
	public WarehouseInVO(String code, String area, int row, int shelf,
			int position) {
		super(code);
		this.code = code;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}
	public WarehouseInVO(String a,String co,String b,String c,String d,int e,int f,int g,String h){
		super(co);
		bar = a;
		code = co;
		inDate=b;
		destination = c;
		area = d;
		row = e;
		shelf = f;
		position = g;
		damageCondition =h;
	}
	public boolean writeWarehouseInInfo(WarehouseIn whi){
		this.code = whi.getCode();
		this.bar=whi.getBar();
		this.destination=whi.getDestination();
		this.inDate=whi.getInDate();
		this.area=whi.getArea();
		this.row=whi.getRow();
		this.shelf=whi.getShelf();
		this.position=whi.getPosition();
		this.damageCondition=whi.getDamageCondition();
		return true;
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
	
}
