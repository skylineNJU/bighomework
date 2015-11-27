package main.po;

import java.util.ArrayList;

public class VehicleListPO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<VehicleInfoPO> vehicleList=new ArrayList<VehicleInfoPO>();
	public void add(VehicleInfoPO po){
		vehicleList.add(po);
	}
	
	public ArrayList<VehicleInfoPO> getList(){
		return this.vehicleList;
	}
}
