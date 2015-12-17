package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class StaffListPO extends Message {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<WorkerPO> poList = new ArrayList<WorkerPO>();
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("StaffInfo");
		String key = poList.get(0).getBelong();
		poList.clear();
		while(reader.findNext("所属单位", key)){
			WorkerPO workerPO = new WorkerPO(reader.getString("员工姓名"), reader.getString("职位"), 
					key, reader.getString("入职时间"),  reader.getString("职工账号"));
			poList.add(workerPO);
		}
	}
}
