package main.vo;

import java.util.ArrayList;

public class IntermediateInfoVO {
	private String city;
	private String institutionCode;
	private double area;
	private int staffNum;
	private ArrayList<WarehouseInfoVO> warehouseInfoList=new ArrayList<WarehouseInfoVO>();
	
	public IntermediateInfoVO(String city, String institutionCode, double area, int staffNum) {
		super();
		this.setCity(city);
		this.setInstitutionCode(institutionCode);
		this.setArea(area);
		this.setStaffNum(staffNum);
	}

	public void addWarehouse(WarehouseInfoVO vo){
		warehouseInfoList.add(vo);
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

	public ArrayList<WarehouseInfoVO> getWarehouseInfoList() {
		return warehouseInfoList;
	}

	public void setWarehouseInfoList(ArrayList<WarehouseInfoVO> warehouseInfoList) {
		this.warehouseInfoList = warehouseInfoList;
	}
	
}
