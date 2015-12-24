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
				"�������� Text(30)",
				"������� Text(30)",
				"Ա������ Number",
				"ռ����� Number"
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
			String content="'"+reader.getString("��������")
			+"','"+reader.getString("�������")+"',"
			+reader.getInt("Ա������")+","
			+reader.getDouble("ռ�����");
			writer.writeIntoSql(tableName1, content);
		}
	}
}
