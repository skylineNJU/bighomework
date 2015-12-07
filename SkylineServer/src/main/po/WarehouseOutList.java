package main.po;

import java.util.ArrayList;

public class WarehouseOutList {
	private static final long serialVersionUID = 1L;
	private ArrayList<WarehouseOutPO> WarehouseOutlist=new ArrayList<WarehouseOutPO>();
	
	public void getDataFromBase(){
		for(WarehouseOutPO po:WarehouseOutlist){
			   po.getDataFromBase();
			}
	}
}