package main.po;

import java.util.ArrayList;

public class DriverList extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<DriverInfoPO> driverlist=new ArrayList<DriverInfoPO>();
	
	public void add(DriverInfoPO po){
		driverlist.add(po);
	}
	
	public ArrayList<DriverInfoPO> getlist(){
		return driverlist;	
	}
}
