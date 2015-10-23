package po;

import java.io.Serializable;

public class DriverInfoPO  implements Serializable{
	int driverID;//司机编号
	String name;//姓名
	String birthDay;//出生日期
	String idCard;//身份证号
	String phoneNum;//电话号码
	String firm;//单位
	String sex;//性别
	String dueDate;//行驶证期限
	
	public DriverInfoPO(int i,String j,String k,String m,String n,String o,String p,String q){
		driverID=i;
		name=j;
		birthDay=k;
		idCard=m;
		phoneNum=n;
		firm=o;
		sex=p;
		dueDate=q;
	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
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

	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
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
