package main.vo;

//�����˻�
public class BankAccountVO {
	private String code;
	double balance;
	
	//code��ʾ�����˻���balance��ʾ�˻����
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
