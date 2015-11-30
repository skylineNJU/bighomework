package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//银行账户信息
public class BankAccountPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String account;//银行账户ID
	private double money;//余额
	
	//银行账户统一编号为1
	public BankAccountPO(String account,double money){
		this.account = account;
		this.money = money;
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("BankAccount");
		reader.findNext("账户编号","1");
		this.account = reader.getString("银行账户名");
		this.money=reader.getDouble("余额");
		reader.close();
	}

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+account+"','"+money+"'";
		writer.writeIntoSql("BankAccount", content);
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}
