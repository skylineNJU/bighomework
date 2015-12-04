package main.po;

import java.util.ArrayList;

public class AccountListPO extends Message{

	private static final long serialVersionUID = 1L;
	private ArrayList<AccountPO> list=new ArrayList<AccountPO>();

	
	public AccountListPO(String codeList){
		String[] codes=codeList.split(" ");
		for(int x=1;x<codes.length;x++){
			AccountPO po=new AccountPO("","",null,"");
			po.setCode(codes[x]);
			list.add(po);
		}
	}
	
	public ArrayList<AccountPO> getList(){
		return list;
	}
}
