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
				"���ڳ��� Text(30)",
				"Ա������ Number",
				"�ֿ���� Number",
				"����ֵ Number",
				"���� Text(30)"
		};
		
		if(builder.createTable(titleName)){
			SqlReader reader=new SqlReader("WarehouseInfo");
			SqlWriter writer=new SqlWriter();
			while(reader.hasNext()){
				String content="'"+reader.getString("���ڳ���")+
						"',"+reader.getInt("Ա������")+","+
						reader.getDouble("�ֿ����")+","+
						reader.getDouble("����ֵ")+",'"+
						reader.getString("����")+"'";
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
			String content="'"+reader.getString("���ڳ���")+
					"',"+reader.getInt("Ա������")+","+
					reader.getDouble("�ֿ����")+","+
					reader.getDouble("����ֵ")+",'"+
					reader.getString("����")+"'";
			writer.writeIntoSql(tableName1, content);
		}
	}
}
