package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class StaffPOList extends Message {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<WorkerPO> poList = new ArrayList<WorkerPO>();
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Cost");
		String key = poList.get(0).getBelong();
		poList.clear();
		while(reader.findNext("������λ", key)){
//			String name, String position, String belong, String age, String code
			WorkerPO workerPO = new WorkerPO(reader.getString("Ա������"), reader.getString("ְλ"), 
					key, key, key);
			poList.add(costPO);
		}
	}
}
