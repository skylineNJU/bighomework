package main.presentation.mainui.memory;

public class LobbyMemory extends Memory {
	private String receiveCode;
	private String earnCode;
	private String receiveDate;
	private String earnDate;
	public LobbyMemory(String userName, String code, String receiveCode, String earnCode, String receiveDate,
			String earnDate) {
		super(userName, code);
		this.setReceiveCode(receiveCode);
		this.setEarnCode(earnCode);
		this.setReceiveDate(receiveDate);
		this.setEarnDate(earnDate);
	}
	public String getReceiveCode() {
		return receiveCode;
	}
	public void setReceiveCode(String receiveCode) {
		this.receiveCode = receiveCode;
	}
	public String getEarnCode() {
		return earnCode;
	}
	public void setEarnCode(String earnCode) {
		this.earnCode = earnCode;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getEarnDate() {
		return earnDate;
	}
	public void setEarnDate(String earnDate) {
		this.earnDate = earnDate;
	}
	
	
}
