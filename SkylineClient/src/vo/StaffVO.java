package vo;

import businesslogic.infobl.Staff;

public class StaffVO {
	private String name;
	private String job;
	private String unit;
	private String workage;
	private String code;
	
	public StaffVO(String na,String jo,String un,String wo,String co){
		name=na;
		job=jo;
		unit=un;
		workage=wo;
		code=co;
	}
	
	public boolean writeStaffInfo(Staff staffInfo){
		this.name=staffInfo.getName();
		this.job=staffInfo.getJob();
		this.unit=staffInfo.getUnit();
		this.workage=staffInfo.getWorkage();
		this.code=staffInfo.getCode();
		return true;
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
