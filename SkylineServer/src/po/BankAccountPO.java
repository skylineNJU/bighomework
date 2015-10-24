package po;

//银行账户信息
public class BankAccountPO {
	private String account;//银行账户ID
	private int money;//余额
	
	public BankAccountPO(String account,int money){
		this.account = account;
		this.money = money;
	}
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	public int getMoney() {
		return money;
	}

}
