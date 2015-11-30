package main.po;

import java.io.Serializable;

//银行账户信息
public class BankAccountPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String account;//银行账户ID
	private double money;//余额
	private String code;
	
	public BankAccountPO(String account,double money){
		this.account = account;
		this.money = money;
	}
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	public double getMoney() {
		return money;
	}

}
