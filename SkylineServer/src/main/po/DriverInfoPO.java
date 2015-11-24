package main.po;

import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class DriverInfoPO extends Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String driverID;//˾�����
	String name;//����
	String birthDay;//��������
	String idCard;//���֤��
	String phoneNum;//�绰����
	String sex;//�Ա�
	String dueDate;//��ʻ֤����
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
		reader.findNext("˾�����",driverID);
		this.name=reader.getString("˾������");
		this.birthDay=reader.getString("˾����������");
		this.dueDate=reader.getString("˾����ʻ֤����");
		this.idCard=reader.getString("˾�����֤��");
		this.phoneNum=reader.getString("˾���ֻ�����");
		this.sex=reader.getString("˾���Ա�");
		this.carunit=reader.getString("˾�����ڵ�λ");
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
