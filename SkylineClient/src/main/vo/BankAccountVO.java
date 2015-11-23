package main.vo;

//“¯––’Àªß
public class BankAccountVO {
	private String code;
	double balance;
	public BankAccountVO(String code,double balance){
		this.code=code;
		this.balance=balance;
	}
	public boolean write(String code,double balance){
		this.code=code;
		this.balance=balance;
		return true;
	}


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public double getBalance(String code) {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
