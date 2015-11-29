package main.presentation.mainui.memory;

public class IntermediateMemory extends Memory{
	private String intermReceiptCode;
	private String airLoadCode;
	private String railLoadCode;
	private String roadLoadCode;
	private String airLoadDate;
	private String railLoadDate;
	private String roadLoadDate;
	private String intermDate;
	public IntermediateMemory(String userName, String code, String intermReceiptCode, String airLoadCode,
			String railLoadCode, String roadLoadCode, String airLoadDate, String railLoadDate, String roadLoadDate,
			String intermDate) {
		super(userName, code);
		this.setIntermReceiptCode(intermReceiptCode);
		this.setAirLoadCode(airLoadCode);
		this.setRailLoadCode(railLoadCode);
		this.setRoadLoadCode(roadLoadCode);
		this.setAirLoadDate(airLoadDate);
		this.setRailLoadDate(railLoadDate);
		this.setRoadLoadDate(roadLoadDate);
		this.setIntermDate(intermDate);
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
	public String getRoadLoadCode() {
		return roadLoadCode;
	}
	public void setRoadLoadCode(String roadLoadCode) {
		this.roadLoadCode = roadLoadCode;
	}
	public String getIntermDate() {
		return intermDate;
	}
	public void setIntermDate(String intermDate) {
		this.intermDate = intermDate;
	}
	
	
}
