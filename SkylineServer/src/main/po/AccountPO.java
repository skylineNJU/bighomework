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
		reader.findNext("账号",ID);
		this.code=reader.getString("密码");
		this.right=Rights.valueOf(reader.getString("权限"));
		this.belong=reader.getString("所属单位");
		reader.close();
	}
	
	public void checkLogin(){
		SqlReader reader=new SqlReader("AccountInfo");
		if(reader.findNext("账号",ID)){
			if(this.code==reader.getString("密码")){
				right=Rights.valueOf(reader.getString("权限"));
				belong=reader.getString("所属单位");
				System.out.println("login success");
				return;
			}
		}else{
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
