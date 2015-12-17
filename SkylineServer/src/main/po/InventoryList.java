package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class InventoryList extends Message {
	
		private static final long serialVersionUID = 1L;
		private ArrayList<InventoryPO> Inventorylist=new ArrayList<InventoryPO>();
		
		public void getDataFromBase(){
			System.out.println("inquire start");
			SqlReader reader=new SqlReader("InventoryInfo");
			String key=Inventorylist.get(0).getArea();
			Inventorylist.clear();
			String bar;
			while(reader.findNext("区号",key)){
				InventoryPO inventoryinfo=new InventoryPO(
						bar=reader.getString("订单号"),
						reader.getString("入库时间"),
						reader.getString("目的地"),
						key,
						Integer.parseInt(reader.getString("排号")),
						Integer.parseInt(reader.getString("架号")),
						Integer.parseInt(reader.getString("位号")));
				Inventorylist.add(inventoryinfo);
				System.out.println("get a bar "+bar);
			}
		//期初建账
			for(InventoryPO po:Inventorylist){
				   po.getDataFromBase();
				}
		
		
		}
	}
