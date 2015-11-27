package main.po;

public class IntermediateReceipt extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountName;
	private String intermReceiptCode;
	private String airLoadCode;
	private String railLoadCode;
	private String roadLoadCode;
	private String airLoadDate;
	private String railLoadDate;
	private String roadLoadDate;
	private String intermDate;
	public IntermediateReceipt(String accountName, String intermReceiptCode, String airLoadCode, String railLoadCode,
			String roadLoadCode, String airLoadDate, String railLoadDate, String roadLoadDate, String intermDate) {
		super();
		this.setAccountName(accountName);
		this.setIntermReceiptCode(intermReceiptCode);
		this.setAirLoadCode(airLoadCode);
		this.setRailLoadCode(railLoadCode);
		this.setRoadLoadCode(roadLoadCode);
		this.setAirLoadDate(airLoadDate);
		this.setRailLoadDate(railLoadDate);
		this.setRoadLoadDate(roadLoadDate);
		this.setIntermDate(intermDate);
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getIntermReceiptCode() {
		return intermReceiptCode;
	}
	public void setIntermReceiptCode(String intermReceiptCode) {
		this.intermReceiptCode = intermReceiptCode;
	}
	public String getAirLoadCode() {
		return airLoadCode;
	}
	public void setAirLoadCode(String airLoadCode) {
		this.airLoadCode = airLoadCode;
	}
	public String getRailLoadCode() {
		return railLoadCode;
	}
	public void setRailLoadCode(String railLoadCode) {
		this.railLoadCode = railLoadCode;
	}
	public String getRoadLoadCode() {
		return roadLoadCode;
	}
	public void setRoadLoadCode(String roadLoadCode) {
		this.roadLoadCode = roadLoadCode;
	}
	public String getAirLoadDate() {
		return airLoadDate;
	}
	public void setAirLoadDate(String airLoadDate) {
		this.airLoadDate = airLoadDate;
	}
	public String getRailLoadDate() {
		return railLoadDate;
	}
	public void setRailLoadDate(String railLoadDate) {
		this.railLoadDate = railLoadDate;
	}
	public String getRoadLoadDate() {
		return roadLoadDate;
	}
	public void setRoadLoadDate(String roadLoadDate) {
		this.roadLoadDate = roadLoadDate;
	}
	public String getIntermDate() {
		return intermDate;
	}
	public void setIntermDate(String intermDate) {
		this.intermDate = intermDate;
	}
	
	
}
