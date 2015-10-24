package po;

import java.io.Serializable;

public class WorkerPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String position;
	private String belong;
	private int age;
	
	//-------------------
	//获取和修改职工的年龄
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
	public WorkerPO(String na,String po,String be,int ag){
		this.name=na;
		this.position=po;
		this.belong=be;
		this.age=ag;
	}
}
