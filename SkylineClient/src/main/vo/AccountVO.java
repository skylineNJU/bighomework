package main.vo;

import main.businesslogic.rightbl.Account;
import main.po.Rights;

public class AccountVO {
	private Rights right;
	private String accountName;
	private String code;
	private String belong;
	public AccountVO(String accountName, String code) {
		super();
		this.setAccountName(accountName);
		this.setCode(code);
		this.setRight(null);
		this.setBelong(null);
	}
	
	public AccountVO(Rights right, String accountName, String code, String belong) {
		super();
		this.setRight(right);
		this.setAccountName(accountName);
		this.setCode(code);
		this.setBelong(belong);
	}
	public boolean writeAccountVO(Account acc){
		this.accountName=acc.getID();
		this.code=acc.getCode();
		this.right=acc.getRight();
		this.belong=acc.getBelong();
		return true;
	}
	public Rights getRight() {
		return right;
	}

	public void setRight(Rights right) {
		this.right = right;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}
	
	
}
