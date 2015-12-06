package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class WarehouseInList extends Message {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<WarehouseInPO> WarehouseInlist=new ArrayList<WarehouseInPO>();
	
	public void getDataFromBase(){
		System.out.println("inquire start");
		SqlReader reader=new SqlReader("WarhouseIn");
		String key=WarehouseInlist.get(0).getCode();
		WarehouseInlist.clear();
		while(reader.findNext("入库单单号",key)){
			WarehouseInPO warehouseInInfo=new WarehouseInPO(
					key,
					reader.getString("区号"),
					Integer.parseInt(reader.getString("排号")),
					Integer.parseInt(reader.getString("架号")),
					Integer.parseInt(reader.getString("位号")));
			WarehouseInlist.add(warehouseInInfo);
			System.out.println("get a code "+key);
		}
	}
}
