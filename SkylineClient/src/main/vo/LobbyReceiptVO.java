package main.vo;

public class LobbyReceiptVO {
	private String accountName;
	private String receiveCode;
	private String earnCode;
	private String receiveDate;
	private String earnDate;
	private String lobbyLoading;
	
	
	public LobbyReceiptVO(String accountName, String receiveCode, String earnCode, String receiveDate, String earnDate,
			String lobbyLoading) {
		super();
		this.accountName = accountName;
		this.receiveCode = receiveCode;
		this.earnCode = earnCode;
		this.receiveDate = receiveDate;
		this.earnDate = earnDate;
		this.setLobbyLoading(lobbyLoading);
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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

	public String getLobbyLoading() {
		return lobbyLoading;
	}

	public void setLobbyLoading(String lobbyLoading) {
		this.lobbyLoading = lobbyLoading;
	}
	
	
	
}
