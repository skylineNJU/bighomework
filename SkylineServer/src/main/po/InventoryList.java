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
			while(reader.findNext("����",key)){
				InventoryPO inventoryinfo=new InventoryPO(
						bar=reader.getString("������"),
						reader.getString("���ʱ��"),
						reader.getString("Ŀ�ĵ�"),
						key,
						Integer.parseInt(reader.getString("�ź�")),
						Integer.parseInt(reader.getString("�ܺ�")),
						Integer.parseInt(reader.getString("λ��")));
				Inventorylist.add(inventoryinfo);
				System.out.println("get a bar "+bar);
			}
		//�ڳ�����
			for(InventoryPO po:Inventorylist){
				   po.getDataFromBase();
				}
		
		
		}
	}
