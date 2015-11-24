package main.po;

import java.io.Serializable;

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
	
	public WorkerPO(String name, String position, String belong, String age, String code) {
		super();
		this.name = name;
		this.position = position;
		this.belong = belong;
		this.age = age;
		this.code = code;
	}
	//-------------------
	//获取和修改职工的年龄
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	public void setCode(String code) {
		this.code = code;
	}
}
