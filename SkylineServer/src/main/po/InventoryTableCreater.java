package main.po;

import main.socketservice.SqlBuilder;
import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class InventoryTableCreater {
	private String tableName;
	public InventoryTableCreater(int id){
		tableName="InventoryInfo"+id;
	}
	
	public void createTable(){
		SqlBuilder builder=new SqlBuilder(tableName);
		
		String[] titleName={
				"订单号 Text(30)",
				"损坏情况 Text(30)",
				"区号 Text(30)",
				"排号 Number",
				"架号 Number",
				"位号 Number",
				"目的地 Text(30)",
				"到达时间 Text(30)"
		};
		
		if(builder.createTable(titleName)){
			SqlReader reader=new SqlReader("InventoryInfo");
			SqlWriter writer=new SqlWriter();
			while(reader.hasNext()){
				String content="'"+reader.getString("订单号")+
						"','"+reader.getString("损坏情况")+
						"','"+reader.getString("区号")+
						"',"+reader.getInt("排号")+
						","+reader.getInt("架号")+
						","+reader.getInt("位号")+
						",'"+reader.getString("目的地")
						+"','"+reader.getString("到达时间")
						+"'";
				writer.writeIntoSql(tableName, content);
			}
		}
	}
	
	public void writeTable(){
		String tableName1="InventoryInfo";
		SqlReader reader=new SqlReader(tableName);
		SqlWriter writer=new SqlWriter();
		SqlDeleter deleter=new SqlDeleter();
		deleter.clearTable(tableName1);
		while(reader.hasNext()){
			String content="'"+reader.getString("订单号")+
					"','"+reader.getString("损坏情况")+
					"','"+reader.getString("区号")+
					"',"+reader.getInt("排号")+
					","+reader.getInt("架号")+
					","+reader.getInt("位号")+
					",'"+reader.getString("目的地")
					+"','"+reader.getString("到达时间")
					+"'";
			writer.writeIntoSql(tableName1, content);
		}
	}
}
