package main.presentation.mainui.memory;

public class CourrierMemory extends Memory {
	
	private String orderCode;
	private String buildDate;
	private String receiveCode;
	private String receiveDate;
	private String distributeCode;
	
	public CourrierMemory(String userName, String code, String orderCode, String buildDate, String receiveCode,
			String receiveDate, String distributeCode) {
		super(userName, code);
		this.setOrderCode(orderCode);
		this.setBuildDate(buildDate);
		this.setReceiveCode(receiveCode);
		this.setReceiveDate(receiveDate);
		this.setDistributeCode(distributeCode);
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}

	public String getReceiveCode() {
		return receiveCode;
	}

	public void setReceiveCode(String receiveCode) {
		this.receiveCode = receiveCode;
	}

	public String getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getDistributeCode() {
		return distributeCode;
	}

	public void setDistributeCode(String distributeCode) {
		this.distributeCode = distributeCode;
	}	
}
