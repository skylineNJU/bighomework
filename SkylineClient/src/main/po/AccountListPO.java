package main.po;

import java.util.ArrayList;

public class AccountListPO extends Message{

	private static final long serialVersionUID = 1L;
	private ArrayList<AccountPO> list=new ArrayList<AccountPO>();

	
	
	
	
	public AccountListPO() {
		// TODO Auto-generated constructor stub
	}


	public ArrayList<AccountPO> getList(){
		return list;
	}

	public void add(AccountPO po) {
		// TODO Auto-generated method stub
		list.add(po);
	}
}
