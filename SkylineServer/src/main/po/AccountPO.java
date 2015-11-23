package main.po;

import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class AccountPO extends Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private String code;
	private Rights right;
	private String belong;
	
	public AccountPO(String iD, String code, Rights right, String belong) {
		super();
		ID = iD;
		this.code = code;
		this.right = right;
		this.belong = belong;
	}

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+ID+"','"+code+"','"+right.name()+"','"+belong+"'";
		writer.writeIntoSql("AccountInfo", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("AccountInfo");
		System.out.println(this.ID);
		reader.findNext("�˺�",ID);
		this.code=reader.getString("����");
		this.right=Rights.valueOf(reader.getString("Ȩ��"));
		this.belong=reader.getString("������λ");
		
		reader.close();
	}
	
	public void checkLogin(){
		SqlReader reader=new SqlReader("AccountInfo");
		System.out.println(ID);
		System.out.println(code);
		if(reader.findNext("�˺�",ID)){
			String code=reader.getString("����");

			if(this.code.equals(code)){
				right=Rights.valueOf(reader.getString("Ȩ��"));
				belong=reader.getString("������λ");
				System.out.println("login success");
				System.out.println(right);
				return;
			}
		}else{
			System.out.println("can not found this account");
			System.out.println("login failed");
			right=null;
			belong=null;
		}
		
	}
	
	
	
	
	
	
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Rights getRight() {
		return right;
	}
	public void setRight(Rights right) {
		this.right = right;
	}
}
