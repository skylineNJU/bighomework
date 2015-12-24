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
				"Ա������ Text(30)",
				"ְλ Text(30)",
				"������λ Text(30)",
				"��ְʱ�� Text(30)",
				"ְ���˺� Text(30)"
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
			String content="'"+reader.getString("Ա������")+
				       "','"+reader.getString("ְλ")+
				       "','"+reader.getString("������λ")+
				       "','"+reader.getString("��ְʱ��")+
				       "','"+reader.getString("ְ���˺�")+"'";
			writer.writeIntoSql(tableName1, content);
		}
	}
}
