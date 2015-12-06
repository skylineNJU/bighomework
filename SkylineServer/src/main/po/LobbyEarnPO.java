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
		while(reader.findNext("��������", key)&&reader.getString("���뵥λ").equals(unit)){
			CollectionPO collectionPO = new CollectionPO(reader.getString("������"),
					key,
					unit,
					reader.getString("�����˻�"),
					reader.getDouble("������"),
					reader.getString("��ע"),
					reader.getString("�Ƿ����"));
			poList.add(collectionPO);
		}
	}
}
