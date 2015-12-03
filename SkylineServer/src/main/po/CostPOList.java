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
		while(reader.findNext("支出日期", key)){
			CostPO costPO = new CostPO(reader.getString("银行账户名"), 
					String.valueOf(reader.getDouble("花费")), 
					reader.getString("支出类型"), 
					key, reader.getString("备注"), 
					reader.getString("付款单单号"));
			cost.add(costPO);
		}
	}
}
