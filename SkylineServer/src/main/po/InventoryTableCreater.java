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
				"������ Text(30)",
				"����� Text(30)",
				"���� Text(30)",
				"�ź� Number",
				"�ܺ� Number",
				"λ�� Number",
				"Ŀ�ĵ� Text(30)",
				"����ʱ�� Text(30)"
		};
		
		if(builder.createTable(titleName)){
			SqlReader reader=new SqlReader("InventoryInfo");
			SqlWriter writer=new SqlWriter();
			while(reader.hasNext()){
				String content="'"+reader.getString("������")+
						"','"+reader.getString("�����")+
						"','"+reader.getString("����")+
						"',"+reader.getInt("�ź�")+
						","+reader.getInt("�ܺ�")+
						","+reader.getInt("λ��")+
						",'"+reader.getString("Ŀ�ĵ�")
						+"','"+reader.getString("����ʱ��")
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
			String content="'"+reader.getString("������")+
					"','"+reader.getString("�����")+
					"','"+reader.getString("����")+
					"',"+reader.getInt("�ź�")+
					","+reader.getInt("�ܺ�")+
					","+reader.getInt("λ��")+
					",'"+reader.getString("Ŀ�ĵ�")
					+"','"+reader.getString("����ʱ��")
					+"'";
			writer.writeIntoSql(tableName1, content);
		}
	}
}
