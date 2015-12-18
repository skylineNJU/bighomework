package main.po;

import java.util.ArrayList;

public class CargoList extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<InventoryPO> Inventorylist=new ArrayList<InventoryPO>();
	public ArrayList<InventoryPO> getInventorylist() {
		return Inventorylist;
	}
	public void setInventorylist(ArrayList<InventoryPO> inventorylist) {
		Inventorylist = inventorylist;
	}
	
	
}
