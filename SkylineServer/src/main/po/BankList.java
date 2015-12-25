package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class BankList extends Message {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<BankAccountPO> bank = new ArrayList<BankAccountPO>();
	
	public ArrayList<BankAccountPO> getBank() {
		return bank;
	}

	public void setBank(ArrayList<BankAccountPO> bank) {
		this.bank = bank;
	}

	public void getDataFromBase(){
		SqlReader reader=new SqlReader("BankAccount");
		bank.clear();
		while(reader.hasNext()){
			BankAccountPO bankPO =new BankAccountPO(reader.getString("�����˻���"), reader.getDouble("���"));
			bank.add(bankPO);
		}
	}
}
