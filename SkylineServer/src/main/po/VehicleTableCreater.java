package main.po;

import java.util.ArrayList;

import main.socketservice.SqlBuilder;
import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class VehicleTableCreater {
	private VehicleList2PO po=new VehicleList2PO();
	private String tableName;
	
	public VehicleTableCreater(int id){
		tableName="VehicleInfo"+id;
		po.getDataFromBase();
	}
	
	public void createTable(){
		SqlBuilder builder=new SqlBuilder(tableName);
		String[] titleName={
				"车牌号 Text(30)",
				"引擎代号 Text(30)",
				"车辆代号 Text(30)",
				"底盘号 Text(30)",
				"购买时间 Text(30)",
				"服役时间 Text(30)"
		};
		if(builder.createTable(titleName)){
			SqlWriter writer=new SqlWriter();
			ArrayList<VehicleInfoPO> poList=po.getList();
			for(VehicleInfoPO vpo:poList){
				String content="'"+vpo.getCarID()+"','"+vpo.getEngineID()+"','"+vpo.gerCarNum()+"','"
		    			+vpo.getUnderpanID()+"','"+vpo.getBoughtTime()+"','"+vpo.getUsedTime()+"'";
		    	writer.writeIntoSql(tableName, content);
			}
		}
	}
	
	public void writeTable(){
		String tableName1="VehicleInfo";
		SqlDeleter deleter=new SqlDeleter();
		SqlWriter writer=new SqlWriter();
		SqlReader reader=new SqlReader(tableName);
		deleter.clearTable(tableName1);
		while(reader.hasNext()){
			String content="'"+reader.getString("车牌号")+"','"+reader.getString("引擎代号")+"','"+reader.getString("车辆代号")+"','"
	    			+reader.getString("底盘号")+"','"+reader.getString("服役时间")+"','"+reader.getString("购买时间")+"'";
			writer.writeIntoSql(tableName1, content);
		}
	}
}
