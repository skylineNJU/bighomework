package main.po;

import java.util.ArrayList;

import main.socketservice.SqlBuilder;
import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class StaffTableCreater {
	private StaffList2PO po;
	private String tableName;
	public StaffTableCreater(int id){
		po=new StaffList2PO();
		po.getDataFromBase();
		tableName="StaffInfo"+id;
	}
	
	public void creatTable(){
		SqlBuilder builder=new SqlBuilder(tableName);
		String[] titleName={
				"员工姓名 Text(30)",
				"职位 Text(30)",
				"所属单位 Text(30)",
				"入职时间 Text(30)",
				"职工账号 Text(30)"
		};
		if(builder.createTable(titleName)){
			SqlWriter writer=new SqlWriter();
			ArrayList<WorkerPO> poList=po.getList();
			for(WorkerPO po:poList){
				String content="'"+po.getName()+
						       "','"+po.getPosition()+
						       "','"+po.getBelong()+
						       "','"+po.getAge()+
						       "','"+po.getCode()+"'";
				writer.writeIntoSql(tableName, content);
			}
		}
	}
	
	public void writeTable(){
		String tableName1="StaffInfo";
		SqlReader reader=new SqlReader(tableName);
		SqlWriter writer=new SqlWriter();
		SqlDeleter deleter=new SqlDeleter();
		deleter.clearTable(tableName1);
		while(reader.hasNext()){
			String content="'"+reader.getString("员工姓名")+
				       "','"+reader.getString("职位")+
				       "','"+reader.getString("所属单位")+
				       "','"+reader.getString("入职时间")+
				       "','"+reader.getString("职工账号")+"'";
			writer.writeIntoSql(tableName1, content);
		}
	}
}
