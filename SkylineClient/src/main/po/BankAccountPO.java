package main.po;

import java.io.Serializable;

//�����˻���Ϣ
public class BankAccountPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String account;//�����˻�ID
	private double money;//���
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
