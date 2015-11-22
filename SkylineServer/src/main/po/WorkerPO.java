package main.po;

import java.io.Serializable;

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
	
	
	public void writeIntoDataBase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+name+"','"+position+"','"+belong+"','"
				+age+"','"+code+"'";
		writer.writeIntoSql("StaffInfo", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("StaffInfo");
		reader.findNext("ְ���˺�",code);
		this.name=reader.getString("ְ������");
		this.position=reader.getString("ְλ");
		this.belong=reader.getString("������λ");
		this.age=reader.getString("��ְʱ��");
		reader.close();
	}
	//-------------------
	//��ȡ���޸�ְ��������
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	//-------------------
	//��ȡ���޸�ְ��������
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//------------------
	//��ȡ���޸�ְ����ְλ
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	//-----------------
	//��ȡ���޸�ְ����������λ
	public String getBelong() {
		return belong;
	}
	public void setBelong(String belong) {
		this.belong = belong;
	}
	
	//----------------------
	//���캯��
	public WorkerPO(String na,String po,String be,String ag){
		this.name=na;
		this.position=po;
		this.belong=be;
		this.age=ag;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
