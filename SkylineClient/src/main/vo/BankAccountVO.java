package main.vo;

//银行账户
public class BankAccountVO {
	private String code;
	double balance;
	
	//code表示银行账户，balance表示账户余额
	public BankAccountVO(String code,double balance){
		this.code=code;
		this.balance=balance;
	}
	
	public boolean write(BankAccountVO bankAccountVO){
		this.code = bankAccountVO.getCode();
		this.balance = bankAccountVO.getBalance();
		return true;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
