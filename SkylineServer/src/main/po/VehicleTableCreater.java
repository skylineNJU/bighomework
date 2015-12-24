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
				"���ƺ� Text(30)",
				"������� Text(30)",
				"�������� Text(30)",
				"���̺� Text(30)",
				"����ʱ�� Text(30)",
				"����ʱ�� Text(30)"
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
			String content="'"+reader.getString("���ƺ�")+"','"+reader.getString("�������")+"','"+reader.getString("��������")+"','"
	    			+reader.getString("���̺�")+"','"+reader.getString("����ʱ��")+"','"+reader.getString("����ʱ��")+"'";
			writer.writeIntoSql(tableName1, content);
		}
	}
}
