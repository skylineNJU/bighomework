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
	
	//无参数构造函数
	public DriverVO(){}
	
	public DriverVO(String name, String code, String age, String iDcode,
			String phoneNumber, String sex, String limit) {
		this.name = name;
		this.code = code;
		this.age = age;
		IDcode = iDcode;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
		this.limit = limit;
	}
	public boolean writeDriverInfo(Driver driver){
		this.age=driver.getAge();
		this.code=driver.getCode();
		this.IDcode=driver.getIDcode();
		this.limit=driver.getLimit();
		this.name=driver.getName();
		this.phoneNumber=driver.getPhoneNumber();
		this.sex=driver.getSex();
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
