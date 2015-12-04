package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class CostPOList extends Message {
	private static final long serialVersionUID = 1L;
	private ArrayList<CostPO> cost = new ArrayList<CostPO>();
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Cost");
		String key = cost.get(0).getCostDate();
		cost.clear();
		while(reader.findNext("֧������", key)){
			CostPO costPO = new CostPO(reader.getString("�����˻���"), 
					String.valueOf(reader.getDouble("����")), 
					reader.getString("֧������"), 
					key, reader.getString("��ע"), 
					reader.getString("�������"));
			cost.add(costPO);
		}
	}
}
