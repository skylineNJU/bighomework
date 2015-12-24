package main.po;

import main.socketservice.SqlBuilder;
import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class WarehouseTableCreater {
	private String tableName;
	
	public WarehouseTableCreater(int x){
		tableName="WarehouseInfo"+x;
	}
	
	public void createTable(){
		SqlBuilder builder=new SqlBuilder(tableName);
		String[] titleName={
				"所在城市 Text(30)",
				"员工人数 Number",
				"仓库面积 Number",
				"警戒值 Number",
				"区号 Text(30)"
		};
		
		if(builder.createTable(titleName)){
			SqlReader reader=new SqlReader("WarehouseInfo");
			SqlWriter writer=new SqlWriter();
			while(reader.hasNext()){
				String content="'"+reader.getString("所在城市")+
						"',"+reader.getInt("员工人数")+","+
						reader.getDouble("仓库面积")+","+
						reader.getDouble("警戒值")+",'"+
						reader.getString("区号")+"'";
				writer.writeIntoSql(tableName, content);
			}
		}
	}
	
	public void writeTable(){
		String tableName1="WarehouseInfo";
		SqlDeleter deleter=new SqlDeleter();
		SqlWriter writer=new SqlWriter();
		SqlReader reader=new SqlReader(tableName);
		deleter.clearTable(tableName1);
		while(reader.hasNext()){
			String content="'"+reader.getString("所在城市")+
					"',"+reader.getInt("员工人数")+","+
					reader.getDouble("仓库面积")+","+
					reader.getDouble("警戒值")+",'"+
					reader.getString("区号")+"'";
			writer.writeIntoSql(tableName1, content);
		}
	}
}
