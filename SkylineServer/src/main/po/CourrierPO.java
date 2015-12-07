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
		while(reader.findNext("所属单位",belong)){
			if(reader.getString("权限").equals("COURIER"))
			courrierAccountList.add(reader.getString("账号"));
		}
		reader.close();
		reader=new SqlReader("CourrierReceipt");
		for(String str:courrierAccountList){
			if(reader.findNext("账户名", str)){
				courrierList.add(reader.getString("派件单单号"));
			}else{
				courrierList.add(null);
			}
		}
		this.setKey("success");
		reader.close();
	}
}
