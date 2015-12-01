package main.po;

import java.util.ArrayList;

public class TrainLoadListPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<TrainLoadingPO> poList;
	
	public ArrayList<TrainLoadingPO> getPoList() {
		return poList;
	}
	
	public void getDataFromBase(){
		System.out.println(poList.size());
		System.out.println("inquire train");	
		for(TrainLoadingPO po:poList){
			System.out.println("get a data");
			po.getDataFromBase();
		}
		System.out.println("finish");
	}
}
