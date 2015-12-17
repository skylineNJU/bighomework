package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

//Ӫҵ���տ����
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
		while(reader.findNext("��������", key)&&reader.getString("���뵥λ").equals(unit)){
			System.out.println("find one");
			CollectionPO collectionPO = new CollectionPO(reader.getString("������"),
					key,
					unit,
					reader.getString("�����˻�"),
					reader.getDouble("�տ���"),
					reader.getString("��ע"),
					reader.getString("�Ƿ����"));
			poList.add(collectionPO);
		}
	}
}
