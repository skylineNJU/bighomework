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
	private String code;//number指的是编号
	public BankAccountPO(String account,double money,String code){
		this.account = account;
		this.money = money;
		this.code = code;
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("BankAccount");
		System.out.println("--------------this.getCode()--------------");
		reader.findNext("账户编号",this.getCode());
		this.account = reader.getString("银行账户名");
		this.money=reader.getDouble("余额");
		reader.close();
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
