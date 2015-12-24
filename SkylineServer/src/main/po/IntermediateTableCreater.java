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
				"���ڳ��� Text(30)",
				"������� Text(30)",
				"ռ����� Number",
				"Ա������ Number"
		};
		
		if(builder.createTable(titleName)){
			SqlReader reader=new SqlReader("IntermediateInfo");
			SqlWriter writer=new SqlWriter();
			while(reader.hasNext()){
				String content="'"+reader.getString("���ڳ���")
				+"','"+reader.getString("�������")+"',"+
						reader.getDouble("ռ�����")+","+
				reader.getDouble("Ա������");
				writer.writeIntoSql(tableName, content);
			}
		}
	}
}
