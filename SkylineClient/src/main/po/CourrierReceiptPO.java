package main.po;

//记录每个人写过的单据的编码
public class CourrierReceiptPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String account;
	private String orderCode;
	private String buildDate;
	private String receiveCode;
	private String receiveDate;
	private String distributeCode;
	public CourrierReceiptPO(String account, String orderCode, String buildDate, String receiveCode, String receiveDate,
			String distributeCode) {
		super();
		this.setAccount(account);
		this.setOrderCode(orderCode);
		this.setBuildDate(buildDate);
		this.setReceiveCode(receiveCode);
		this.setReceiveDate(receiveDate);
		this.setDistributeCode(distributeCode);
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
