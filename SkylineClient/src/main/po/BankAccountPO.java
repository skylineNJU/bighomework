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
	
	public BankAccountPO(String account,int money,String code){
		this.account = account;
		this.money = money;
		this.code = code;
	}
	public String getAccount() {
		return account;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public double getMoney() {
		return money;
	}

}
