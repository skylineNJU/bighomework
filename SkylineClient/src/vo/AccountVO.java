package vo;

import po.Rights;

public class AccountVO {
	private String accountName;
	//private double balance;
	private String code;
	private RightVO right;
	public AccountVO(String name,String code,RightVO right){
		this.accountName=name;
		this.code=code;
		this.right=right;
	}
	public AccountVO(String name, double d) {
		// TODO Auto-generated constructor stub
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
	public RightVO getRight() {
		return right;
	}
	public void setRight(RightVO right) {
		this.right = right;
	}
	public void setBalance(double d) {
		// TODO Auto-generated method stub
		
	}
	
	
//	public double getBalance() {
//		return balance;
//	}
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
}
