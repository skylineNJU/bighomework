package main.po;

import main.socketservice.SqlBuilder;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class IntermediateTableCreater {
	private String tableName;
	
	public IntermediateTableCreater(int id){
		this.tableName="IntermediateInfo"+id;
	}
	
	public void createTable(){
		SqlBuilder builder=new SqlBuilder(tableName);
		String[] titleName={
				"所在城市 Text(30)",
				"机构编号 Text(30)",
				"占地面积 Number",
				"员工人数 Number"
		};
		
		if(builder.createTable(titleName)){
			SqlReader reader=new SqlReader("IntermediateInfo");
			SqlWriter writer=new SqlWriter();
			while(reader.hasNext()){
				String content="'"+reader.getString("所在城市")
				+"','"+reader.getString("机构编号")+"',"+
						reader.getDouble("占地面积")+","+
				reader.getDouble("员工人数");
				writer.writeIntoSql(tableName, content);
			}
		}
	}
}
