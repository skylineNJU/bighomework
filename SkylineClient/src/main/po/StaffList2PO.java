package main.po;

import java.util.ArrayList;

public class StaffList2PO extends Message{
		private static final long serialVersionUID = 1L;
		private ArrayList<WorkerPO> workerList=new ArrayList<WorkerPO>();
		public void add(WorkerPO po){
			workerList.add(po);
		}
		
		public ArrayList<WorkerPO> getList(){
			return this.workerList;
		}
	}
