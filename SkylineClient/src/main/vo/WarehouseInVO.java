package main.vo;

import main.businesslogic.warehousebl.WarehouseIn;


public class WarehouseInVO extends ReceiptVO {

// TODO Auto-generated constructor stub
	private String bar;//��ⵥ���
	private String destination;//Ŀ�ĵ�
	private String inDate;//�������
	private char area;//����
	private int row;//�ź�
	private int shelf;//�ܺ�
	private int position;//λ��
	
	public WarehouseInVO(String id,String da,String co,String a,String b,String c,char d,int e,int f,int g){
		super(id, da, co);
		bar = a;
		inDate=b;
		destination = c;
		area = d;
		row = e;
		shelf = f;
		position = g;
	}
	public boolean writeWarehouseInInfo(WarehouseIn whi){
		this.bar=whi.getBar();
		this.destination=whi.getDestination();
		this.inDate=whi.getInDate();
		this.area=whi.getArea();
		this.row=whi.getRow();
		this.shelf=whi.getShelf();
		this.position=whi.getPosition();
		return true;
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
	
}
