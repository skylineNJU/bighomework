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
		while(reader.findNext("��ⵥ����",key)){
			WarehouseInPO warehouseInInfo=new WarehouseInPO(
					key,
					reader.getString("����"),
					Integer.parseInt(reader.getString("�ź�")),
					Integer.parseInt(reader.getString("�ܺ�")),
					Integer.parseInt(reader.getString("λ��")));
			WarehouseInlist.add(warehouseInInfo);
			System.out.println("get a code "+key);
		}
	}
}
