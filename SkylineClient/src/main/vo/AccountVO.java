package main.vo;

import main.State.Rights;

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
	
	public AccountVO(RightVO right, String accountName, String code, String belong) {
		super();
		this.setRight(right);
		this.setAccountName(accountName);
		this.setCode(code);
		this.setBelong(belong);
	}

	public RightVO getRight() {
		return right;
	}

	public void setRight(RightVO right) {
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
