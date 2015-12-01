package main.po;

import java.util.ArrayList;


public class VehicleLoadListPO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<VehicleLoadingPO> loadList=new ArrayList<VehicleLoadingPO>();
	
	public void getDataFromBase(){
		for(VehicleLoadingPO po:loadList){
			po.getDataFromBase();
		}
	}
}
