package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class DistributePOList extends Message{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<DistributePO> distributeList = new ArrayList<DistributePO>();
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Distribute");
		String key = distributeList.get(0).getCourrierName();
		distributeList.clear();
		while(reader.hasNext("���Ա�˺�",key)){
			DistributePO distributePO = new DistributePO(reader.getString("���͵���"),
					reader.getString("������"),
					reader.getString("�ռ�������"),
					reader.getString("�ռ��˵�ַ"),
					reader.getString("�ռ����ֻ���"),
					key
					);
			distributeList.add(distributePO);
		}
	}
}