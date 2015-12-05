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
	    	AccountPO po=new AccountPO(reader.getString("账号"),
	    			reader.getString("密码"),
	    			Rights.valueOf(reader.getString("权限")),
	    			reader.getString("所属单位"));
	    	list.add(po);
	    }
	    System.out.println("啊啊啊"+list.size());
	    reader.close();
	}
}
