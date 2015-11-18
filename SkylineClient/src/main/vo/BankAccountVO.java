package main.vo;

//“¯––’Àªß
public class BankAccountVO {
	//private double balance;
	private String code;
	String balance;
	public BankAccountVO(String code,String balance){
		this.code=code;
		this.balance=balance;
	}
	public boolean write(String code,String balance){
		this.code=code;
		this.balance=balance;
		return true;
	}
	public BankAccountVO(String name, double d) {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getBalance(String code) {
		
		return balance;
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
