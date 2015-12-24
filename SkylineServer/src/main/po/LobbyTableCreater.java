package main.po;

import java.util.ArrayList;

import main.socketservice.SqlBuilder;
import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class LobbyTableCreater {
	private LobbyInfoList list=new LobbyInfoList();
	private String tableName;
	
	public LobbyTableCreater(int id){
		tableName="LobbyInfo"+id;
		list.getAllDataFromBase();
	}
	
	public void createTable(){
		SqlBuilder builder=new SqlBuilder(tableName);
		String[] titleName={
				"所属城市 Text(30)",
				"机构编号 Text(30)",
				"员工人数 Number",
				"占地面积 Number"
		};
		
		if(builder.createTable(titleName)){
			SqlWriter writer=new SqlWriter();
			ArrayList<LobbyInfo> polist=list.getLobbyList();
			for(LobbyInfo po:polist){
				String content="'"+po.getCity()
						+"','"+po.getLobbyCode()
						+"',"+po.getStaffNum()
						+","+po.getArea();
				writer.writeIntoSql(tableName, content);
			}
		}
	}
	
	public void writeTable(){
		String tableName1="LobbyInfo";
		SqlReader reader=new SqlReader(tableName);
		SqlWriter writer=new SqlWriter();
		SqlDeleter deleter=new SqlDeleter();
		deleter.clearTable(tableName1);
		while(reader.hasNext()){
			String content="'"+reader.getString("所属城市")
			+"','"+reader.getString("机构编号")+"',"
			+reader.getInt("员工人数")+","
			+reader.getDouble("占地面积");
			writer.writeIntoSql(tableName1, content);
		}
	}
}
