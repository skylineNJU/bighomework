package main.po;

import java.io.Serializable;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class WorkerPO extends Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String position;
	private String belong;
	private String age;
	private String code;
	private String salary;
	private String commission;
	
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		System.out.println("save staffinfo");
		String content="'"+name+"','"+position+"','"+belong+"','"
				+age+"','"+code+"'";
		writer.writeIntoSql("StaffInfo", content);
	}
	
	
	public WorkerPO(String name, String position, String belong, String age,
			String code, String salary, String commission) {
		super();
		this.name = name;
		this.position = position;
		this.belong = belong;
		this.age = age;
		this.code = code;
		this.salary = salary;
		this.commission = commission;
	}
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("StaffInfo");
		if(reader.findNext("职工账号",code)){
		this.name=reader.getString("员工姓名");
		this.position=reader.getString("职位");
		this.belong=reader.getString("所属单位");
		this.age=reader.getString("入职时间");
		}else{
			this.name=null;
			this.position=null;
			this.belong=null;
			this.age=null;
		}
		System.out.println(this.name);
		reader.close();
		
		
	}
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("StaffInfo","职工账号",code);
	}
	
	//-------------------
	//获取和修改职工的年龄
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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


	//-------------------
	//获取和修改职工的名字
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//------------------
	//获取和修改职工的职位
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	//-----------------
	//获取和修改职工的所属单位
	public String getBelong() {
		return belong;
	}
	public void setBelong(String belong) {
		this.belong = belong;
	}
	
	//----------------------
	//构造函数
	
	public String getCode() {
		return code;
	}
	public WorkerPO(String name, String position, String belong, String age, String code) {
		super();
		this.name = name;
		this.position = position;
		this.belong = belong;
		this.age = age;
		this.code = code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
