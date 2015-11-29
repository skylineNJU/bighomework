package main.presentation.mainui.memory;

public class FinanceMemory extends Memory {
	private String costCode;
	private String earnCode;
	public FinanceMemory(String userName, String code, String costCode, String earnCode) {
		super(userName, code);
		this.setCostCode(costCode);
		this.setEarnCode(earnCode);
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
