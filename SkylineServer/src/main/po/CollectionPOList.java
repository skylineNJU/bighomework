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
		while(reader.findNext("��������", key)){
			CollectionPO collectionPO = new CollectionPO(reader.getString("������"),
					key,
					reader.getString("���뵥λ"),
					reader.getString("�����˻�"),
					reader.getDouble("������"),
					reader.getString("��ע"),
					reader.getString("�Ƿ����"));
			poList.add(collectionPO);
		}
	}

}
