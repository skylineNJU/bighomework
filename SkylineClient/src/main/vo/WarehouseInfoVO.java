package main.vo;

public class WarehouseInfoVO {
	private String city;
	private int staffNum;
	private double acreage;
	private String area;
	private double alert;
	private double volume;
	
	public WarehouseInfoVO(String city, int staffNum, double acreage, String area,double volume, double alert) {
		super();
		this.setCity(city);
		this.setStaffNum(staffNum);
		this.setAcreage(acreage);
		this.setArea(area);
		this.setVolume(volume);
		this.setAlert(alert);
		
	}

	
	public double getVolume() {
		return volume;
	}


	public void setVolume(double volume) {
		this.volume = volume;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getStaffNum() {
		return staffNum;
	}

	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}

	public double getAcreage() {
		return acreage;
	}

	public void setAcreage(double acreage) {
		this.acreage = acreage;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public double getAlert() {
		return alert;
	}

	public void setAlert(double alert) {
		this.alert = alert;
	}
	
	
}
