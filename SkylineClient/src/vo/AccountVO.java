package vo;

import po.Rights;

public class AccountVO {
	private String accountName;
	//private double balance;
	private String code;
	private Rights right;
	public AccountVO(String name,String code,Rights right){
		this.accountName=name;
		this.code=code;
		this.right=right;
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
	public Rights getRight() {
		return right;
	}
	public void setRight(Rights right) {
		this.right = right;
	}
	
	
//	public double getBalance() {
//		return balance;
//	}
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
}
