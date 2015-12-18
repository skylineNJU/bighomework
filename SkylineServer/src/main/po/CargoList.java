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
					reader.getString("������"),
					null,null,
					reader.getString("����ʱ��"),
					reader.getString("Ŀ�ĵ�"),
					reader.getString("����"),
					Integer.parseInt(reader.getString("�ź�")),
					Integer.parseInt(reader.getString("�ܺ�")),
					Integer.parseInt(reader.getString("λ��")),
					
					reader.getString("�����")
					);
			Inventorylist.add(inventoryinfo);
		}
	}
}
