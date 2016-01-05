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
		if(reader.findNext("所在城市",this.city)){
			this.institutionCode=reader.getString("机构编号");
			this.area=reader.getDouble("占地面积");
			this.staffNum=reader.getInt("员工人数");
		}
		reader.close();
		reader=new SqlReader("WarehouseInfo");
		while(reader.findNext("所在城市",city)){
			WarehouseInfo info=new WarehouseInfo(city,reader.getInt("员工人数"),reader.getDouble("仓库面积"),
					reader.getString("区号"),0,reader.getDouble("警戒值"));
			warehouseInfoList.add(info);
		}
	}
	
	public void modifyTheDate(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("IntermediateInfo","所在城市",city);
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
		deleter.deleteData("IntermediateInfo","所在城市",city);
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
