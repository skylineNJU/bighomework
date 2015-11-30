package main.po;

import java.util.ArrayList;

public class BankList extends Message{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<BankAccountPO> bank = new ArrayList<BankAccountPO>();
	
	public void add(BankAccountPO bankPO){
		bank.add(bankPO);	
	}
	
	public ArrayList<BankAccountPO> getList(){
		return bank;
	}
}
