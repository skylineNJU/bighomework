package main.vo;

import main.businesslogic.infobl.Driver;

public class DriverVO {
	private String name;
	private String code;
	private String age;
	private String IDcode;
	private String phoneNumber;
	private String sex;
	private String limit;
	
	public DriverVO(String na,String co,String ag,String id,String ph,String se,String li ){
		name=na;
		code=co;
		age=ag;
		IDcode=id;
		phoneNumber=ph;
		sex=se;
		limit=li;
	}
	
	public boolean writeDriverInfo(Driver dr){
		this.age=dr.getAge();
		this.code=dr.getCode();
		this.IDcode=dr.getIDcode();
		this.limit=dr.getLimit();
		this.name=dr.getName();
		this.phoneNumber=dr.getPhoneNumber();
		this.sex=dr.getSex();
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getIDcode() {
		return IDcode;
	}
	public void setIDcode(String iDcode) {
		IDcode = iDcode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
}
