package main.po;

import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

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

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+name+"','"+driverID+"','"+birthDay
				+"','"+idCard+"','"+phoneNum+"','"+sex+"','"
				+dueDate+"','"+carunit+"'";
		writer.writeIntoSql("DriverInfo", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("DriverInfo");
		reader.findNext("司机编号",driverID);
		this.name=reader.getString("司机姓名");
		this.birthDay=reader.getString("司机出生日期");
		this.dueDate=reader.getString("司机行驶证期限");
		this.idCard=reader.getString("司机身份证号");
		this.phoneNum=reader.getString("司机手机号码");
		this.sex=reader.getString("司机性别");
		this.carunit=reader.getString("司机所在单位");
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
	
}
