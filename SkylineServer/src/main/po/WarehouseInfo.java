package main.po;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class WarehouseInfo extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private int staffNum;
	private double acreage;
	private String area;
	private double alert;
	private double volume;
	
	public WarehouseInfo(String city, int staffNum, double acreage, String area, double volume,double alert) {
		super();
		this.city = city;
		this.staffNum = staffNum;
		this.acreage = acreage;
		this.area = area;
		this.volume=volume;
		this.alert = alert;
	}

	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("WarehouseInfo","���ڳ���",city);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("WarehouseInf");
		if(reader.findNext("���ڳ���",city)){
			this.staffNum=reader.getInt("Ա������");
			this.alert=reader.getDouble("����ֵ");
			this.volume=reader.getDouble("�ֿ�������");
			this.acreage=reader.getDouble("�ֿ����");
			this.area=reader.getString("����");
		}
		
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+this.city+"',"
				          +this.staffNum+","
				          +this.acreage+","+
				          +this.volume+","+
				          this.alert+",'"
				          +this.area+"'";
		writer.writeIntoSql("WarehouseInfo", content);
	}
}
