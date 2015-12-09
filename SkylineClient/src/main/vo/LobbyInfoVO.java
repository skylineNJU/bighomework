package main.vo;

public class LobbyInfoVO {
	private String city;
	private String lobbyCode;
	private int staffNum;
	private double area;
	
	public LobbyInfoVO(String city, String lobbyCode, int staffNum, double area) {
		super();
		this.setCity(city);
		this.setLobbyCode(lobbyCode);
		this.setStaffNum(staffNum);
		this.setArea(area);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLobbyCode() {
		return lobbyCode;
	}

	public void setLobbyCode(String lobbyCode) {
		this.lobbyCode = lobbyCode;
	}

	public int getStaffNum() {
		return staffNum;
	}

	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	
}
