package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class WarehouseInList extends Message {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<WarehouseInPO> WarehouseInlist=new ArrayList<WarehouseInPO>();
	
	public void getDataFromBase(){
		System.out.println("inquire start");
		SqlReader reader=new SqlReader("WarhouseIn");
		for(WarehouseInPO po:WarehouseInlist){
			po.getDataFromBase();
		}
	}
}
