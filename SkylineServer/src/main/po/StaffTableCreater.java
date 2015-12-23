package main.po;

import java.util.ArrayList;

import main.socketservice.SqlBuilder;
import main.socketservice.SqlWriter;

public class StaffTableCreater {
	private StaffList2PO po;
	private int tableID;
	private String tableName;
	public StaffTableCreater(int id){
		po=new StaffList2PO();
		tableID=id;
		po.getDataFromBase();
		tableName="StaffInfo"+tableID;
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
}
