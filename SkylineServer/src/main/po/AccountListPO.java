package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class AccountListPO extends Message{

	private static final long serialVersionUID = 1L;
	private ArrayList<AccountPO> list=new ArrayList<AccountPO>();

	public ArrayList<AccountPO> getList(){
		return list;
	}
	
	public void getDataFromBase(){
		list.clear();
		SqlReader reader=new SqlReader("AccountInfo");
	    while(reader.hasNext()){
	    	AccountPO po=new AccountPO(reader.getString("�˺�"),
	    			reader.getString("����"),
	    			Rights.valueOf(reader.getString("Ȩ��")),
	    			reader.getString("������λ"));
	    	list.add(po);
	    }
	    System.out.println("������"+list.size());
	    reader.close();
	}
}
