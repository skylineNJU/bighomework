package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class CourrierPO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private ArrayList<String> courrierList=new ArrayList<String>();
	private ArrayList<String> courrierAccountList=new ArrayList<String>();
	private String belong;
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("AccountInfo");
		while(reader.findNext("������λ",belong)){
			if(reader.getString("Ȩ��").equals("COURIER"))
			courrierAccountList.add(reader.getString("�˺�"));
		}
		reader.close();
		reader=new SqlReader("CourrierReceipt");
		for(String str:courrierAccountList){
			if(reader.findNext("�˻���", str)){
				courrierList.add(reader.getString("�ɼ�������"));
			}else{
				courrierList.add(null);
			}
		}
		this.setKey("success");
		reader.close();
	}
}
