package main.po;

import java.io.Serializable;

public class DriverInfoPO extends Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String driverID;//司机编号
	String name;//姓名
	String birthDay;//出生日期
	String idCard;//身份证号
	String phoneNum;//电话号码
	String sex;//性别
	String dueDate;//行驶证期限
	String carunit;
	

	

	public DriverInfoPO(String carunit) {
		super();
		this.carunit = carunit;
	}

	public DriverInfoPO(String driverID, String name, String birthDay, String idCard, String phoneNum, String sex,
			String dueDate, String carunit) {
		super();
		this.driverID = driverID;
		this.name = name;
		this.birthDay = birthDay;
		this.idCard = idCard;
		this.phoneNum = phoneNum;
		this.sex = sex;
		this.dueDate = dueDate;
		this.carunit = carunit;
	}

	public String getDriverID() {
		return driverID;
	}

	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getCarunit(){
		return this.carunit;
	}
}
