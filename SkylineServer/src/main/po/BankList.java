package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class BankList extends Message {
	private static final long serialVersionUID = 1L;
	private ArrayList<BankAccountPO> bank = new ArrayList<BankAccountPO>();
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("BankAccount");
		bank.clear();
		String key = "1";
		while(reader.findNext("账户编号", key)){
			BankAccountPO bankPO =new BankAccountPO(reader.getString("银行账户名"), reader.getDouble("余额"));
			bank.add(bankPO);
		}
	}
}
