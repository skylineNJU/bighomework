package main.po;

import java.util.ArrayList;

import main.socketservice.SqlBuilder;
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
}
