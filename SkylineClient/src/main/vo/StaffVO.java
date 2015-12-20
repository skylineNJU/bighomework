package main.vo;

import main.businesslogic.infobl.Staff;

public class StaffVO {
	private String name;
	private String job;
	private String unit;
	private String workage;
	private String code;
	private String salary;
	private String commission;
	
	
	
	public StaffVO(String name, String job, String unit, String workage,
			String code) {
		super();
		this.name = name;
		this.job = job;
		this.unit = unit;
		this.workage = workage;
		this.code = code;
	}

	public StaffVO(String name, String job, String unit, String workage,
			String code, String salary, String commission) {
		super();
		this.name = name;
		this.job = job;
		this.unit = unit;
		this.workage = workage;
		this.code = code;
		this.salary = salary;
		this.commission = commission;
	}

	public boolean writeStaffInfo(Staff staffInfo){
		this.name=staffInfo.getName();
		this.job=staffInfo.getJob();
		this.unit=staffInfo.getUnit();
		this.workage=staffInfo.getWorkage();
		this.code=staffInfo.getCode();
		return true;
	}
	
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getWorkage() {
		return workage;
	}
	public void setWorkage(String workage) {
		this.workage = workage;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
