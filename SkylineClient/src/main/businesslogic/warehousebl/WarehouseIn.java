package main.businesslogic.warehousebl;

import main.po.WarehouseInPO;
import main.vo.WarehouseInVO;

public class WarehouseIn {
	private String bar;//��ⵥ���
	private String destination;//Ŀ�ĵ�
	private String inDate;//�������
	private char area;//���� ,
	private int row;//�ź�
	private int shelf;//�ܺ�
	private int position;//λ��
	private WarehouseInPO po;

	
	public WarehouseIn(WarehouseInVO whi){
		this.bar=whi.getBar();
		this.destination=whi.getDestination();
		this.inDate=whi.getInDate();
		this.area=whi.getArea();
		this.row=whi.getRow();
		this.shelf=whi.getShelf();
		this.position=whi.getPosition();
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
		}
	}
	//����̵�
	public boolean check(){
		return true;
	}
	
	public boolean saveInfo(){
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
