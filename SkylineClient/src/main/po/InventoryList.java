package main.po;

import java.util.ArrayList;

public class InventoryList extends Message{

	private static final long serialVersionUID = 1L;
	private ArrayList<InventoryPO>Inventorylist=new ArrayList<InventoryPO>();
	
	public void add(InventoryPO po){
		Inventorylist.add(po);
	}
	
	public ArrayList<InventoryPO> getlist(){
		return Inventorylist;	
	}
}


