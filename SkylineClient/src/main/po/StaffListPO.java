package main.po;

import java.util.ArrayList;

public class StaffListPO extends Message {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<WorkerPO> poList = new ArrayList<WorkerPO>(); 
	
	public void add(WorkerPO workerPO) {
		poList.add(workerPO);
	}
	
	public ArrayList<WorkerPO> getList(){
		return poList;
	}
}
