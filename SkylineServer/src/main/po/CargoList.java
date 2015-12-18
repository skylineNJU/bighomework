package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class CargoList extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<InventoryPO> Inventorylist=new ArrayList<InventoryPO>();
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("InventoryInfo");
		while(reader.hasNext()){
			InventoryPO inventoryinfo=new InventoryPO(
					reader.getString("订单号"),
					null,null,
					reader.getString("到达时间"),
					reader.getString("目的地"),
					reader.getString("区号"),
					Integer.parseInt(reader.getString("排号")),
					Integer.parseInt(reader.getString("架号")),
					Integer.parseInt(reader.getString("位号")),
					
					reader.getString("损坏情况")
					);
			Inventorylist.add(inventoryinfo);
		}
	}
}
