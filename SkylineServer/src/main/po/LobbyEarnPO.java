package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

//营业厅收款单单号
public class LobbyEarnPO extends Message{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<CollectionPO> poList = new ArrayList<CollectionPO>();

	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Collection");
		String key = poList.get(0).getDate();
		String unit = poList.get(0).getUnit();
		poList.clear();
		System.out.println("the unit is:"+unit);
		System.out.println("the key is:"+key);
		while(reader.findNext("收入日期", key)&&reader.getString("收入单位").equals(unit)){
			System.out.println("find one");
			CollectionPO collectionPO = new CollectionPO(reader.getString("入款单单号"),
					key,
					unit,
					reader.getString("收入账户"),
					reader.getDouble("收款金额"),
					reader.getString("备注"),
					reader.getString("是否结算"));
			poList.add(collectionPO);
		}
	}
}
