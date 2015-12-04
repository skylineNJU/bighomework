package main.po;

import java.util.ArrayList;

public class AccountListPO extends Message{

	private static final long serialVersionUID = 1L;
	private ArrayList<AccountPO> list=new ArrayList<AccountPO>();

	public ArrayList<AccountPO> getList(){
		return list;
	}
	
	public void getDataFromBase(){
		for(AccountPO po:list){
			po.getDataFromBase();
		}
	}
}
