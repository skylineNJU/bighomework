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
	private String carunit;
	
	
	
	public DriverVO(String name, String code, String age, String iDcode, String phoneNumber, String sex, String limit,
			String carunit) {
		super();
		this.name = name;
		this.code = code;
		this.age = age;
		IDcode = iDcode;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
		this.limit = limit;
		this.setCarunit(carunit);
	}
	
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
	public String getCarunit() {
		return carunit;
	}
	public void setCarunit(String carunit) {
		this.carunit = carunit;
	}
}
