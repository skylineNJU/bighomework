package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class StaffList2PO extends Message{
		private static final long serialVersionUID = 1L;
		private ArrayList<WorkerPO> workerList=new ArrayList<WorkerPO>();
		public void add(WorkerPO po){
			workerList.add(po);
		}
		
		public ArrayList<WorkerPO> getList(){
			return this.workerList;
		}
		
		public void getDataFromBase(){
			SqlReader reader=new SqlReader("StaffInfo");
			while(reader.hasNext()){
				WorkerPO po=new WorkerPO(
						reader.getString("员工姓名"),
						reader.getString("职位"),
						reader.getString("所属单位"),
						reader.getString("入职时间"),
						reader.getString("职工账号")
						);
				workerList.add(po);
			}
		}
	}
