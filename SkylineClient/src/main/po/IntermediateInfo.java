package main.po;

import java.util.ArrayList;

public class IntermediateInfo extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<WarehouseInfo> warehouseInfoList=new ArrayList<WarehouseInfo>();
	private String city;
	private String institutionCode;
	private double area;
	private int staffNum;
	
	public ArrayList<WarehouseInfo> getWarehouseInfoList() {
		return warehouseInfoList;
	}

	public void setWarehouseInfoList(ArrayList<WarehouseInfo> warehouseInfoList) {
		this.warehouseInfoList = warehouseInfoList;
	}

	public IntermediateInfo(String city, String institutionCode, double area, int staffNum) {
		super();
		this.setCity(city);
		this.setInstitutionCode(institutionCode);
		this.setArea(area);
		this.setStaffNum(staffNum);
	}
	
	public void addWarehouse(WarehouseInfo info){
		this.warehouseInfoList.add(info);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getStaffNum() {
		return staffNum;
	}

	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}
}
