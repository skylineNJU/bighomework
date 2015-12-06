package main.po;

import java.io.Serializable;


public class AccountPO extends Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;//账户名
	private String code;//密码
	private Rights right;//权限
	private String belong;//机构
	
	
	public AccountPO(String ID, String code, Rights right, String belong) {
		super();
		this.ID=ID;
		this.code = code;
		this.right = right;
		this.setBelong(belong);
	}


	public AccountPO() {
		// TODO Auto-generated constructor stub
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


	public String getBelong() {
		return belong;
	}


	public void setBelong(String belong) {
		this.belong = belong;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
