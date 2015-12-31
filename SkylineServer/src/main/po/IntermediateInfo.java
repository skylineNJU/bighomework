package main.po;

import java.util.ArrayList;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class IntermediateInfo extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<WarehouseInfo> warehouseInfoList=new ArrayList<WarehouseInfo>();
	private String city;
	private String institutionCode;
	private double area;
	private int staffNum;
	
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("IntermediateInfo");
		if(reader.findNext("���ڳ���",this.city)){
			this.institutionCode=reader.getString("�������");
			this.area=reader.getDouble("ռ�����");
			this.staffNum=reader.getInt("Ա������");
		}
		reader.close();
		reader=new SqlReader("WarehouseInfo");
		while(reader.findNext("���ڳ���",city)){
			WarehouseInfo info=new WarehouseInfo(city,reader.getInt("Ա������"),reader.getDouble("�ֿ����"),
					reader.getString("����"),0,reader.getDouble("����ֵ"));
			warehouseInfoList.add(info);
		}
	}
	
	public void modifyTheDate(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("IntermediateInfo","���ڳ���",city);
		SqlWriter writer=new SqlWriter();
		String content="'"+this.city+"','"
				          +this.institutionCode+"',"
				          +this.area+","+this.staffNum;
		writer.writeIntoSql("IntermediateInfo", content);
		for(WarehouseInfo info:this.warehouseInfoList){
			info.modifyTheDate();
		}
	}
	
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("IntermediateInfo","���ڳ���",city);
		for(WarehouseInfo info:this.warehouseInfoList){
			info.deleteFromDatabase();
		}
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+this.city+"','"
				          +this.institutionCode+"',"
				          +this.area+","+this.staffNum;
		writer.writeIntoSql("IntermediateInfo", content);
		for(WarehouseInfo info:this.warehouseInfoList){
			info.writeIntoDatabase();
		}
	}
	
	
}
