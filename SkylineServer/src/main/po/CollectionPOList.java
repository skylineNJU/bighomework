package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class CollectionPOList extends Message {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<CollectionPO> poList = new ArrayList<CollectionPO>();
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Collection");
		String key = poList.get(0).getDate();
		poList.clear();
		while(reader.findNext("收入日期", key)){
			CollectionPO collectionPO = new CollectionPO(reader.getString("入款单单号"),
					key,
					reader.getString("收入单位"),
					reader.getString("收入账户"),
					reader.getDouble("收入金额"),
					reader.getString("备注"),
					reader.getString("是否结算"));
			poList.add(collectionPO);
		}
	}

}
