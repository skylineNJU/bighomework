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
						reader.getString("Ա������"),
						reader.getString("ְλ"),
						reader.getString("������λ"),
						reader.getString("��ְʱ��"),
						reader.getString("ְ���˺�")
						);
				workerList.add(po);
			}
		}
	}
