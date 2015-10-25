package vo;

public class AccountVO {
	private String accountName;
	private double balance;
	
	public AccountVO(String name,double ba){
		this.accountName=name;
		this.balance=ba;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
