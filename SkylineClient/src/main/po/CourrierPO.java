package main.po;

import java.util.ArrayList;

public class CourrierPO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private ArrayList<String> courrierList=new ArrayList<String>();
	private ArrayList<String> courrierAccountList=new ArrayList<String>();
	private String belong;
	
	public CourrierPO(String belong){
		this.setBelong(belong);
	}

	public ArrayList<String> getCourrierList() {
		return courrierList;
	}

	public void setCourrierList(ArrayList<String> courrierList) {
		this.courrierList = courrierList;
	}

	public ArrayList<String> getCourrierAccountList() {
		return courrierAccountList;
	}

	public void setCourrierAccountList(ArrayList<String> courrierAccountList) {
		this.courrierAccountList = courrierAccountList;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}
}
