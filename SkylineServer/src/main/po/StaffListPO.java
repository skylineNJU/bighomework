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
		while(reader.findNext("������λ", key)){
			WorkerPO workerPO = new WorkerPO(reader.getString("Ա������"), reader.getString("ְλ"), 
					key, reader.getString("��ְʱ��"),  reader.getString("ְ���˺�"));
			poList.add(workerPO);
		}
	}
}
