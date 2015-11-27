package main.po;

public class FinanceReceipt extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountName;
	private String costCode;
	private String earnCode;
	public FinanceReceipt(String accountName, String costCode, String earnCode) {
		super();
		this.setAccountName(accountName);
		this.setCostCode(costCode);
		this.setEarnCode(earnCode);
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCostCode() {
		return costCode;
	}
	public void setCostCode(String costCode) {
		this.costCode = costCode;
	}
	public String getEarnCode() {
		return earnCode;
	}
	public void setEarnCode(String earnCode) {
		this.earnCode = earnCode;
	}
	
	
}
