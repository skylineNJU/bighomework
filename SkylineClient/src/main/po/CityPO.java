package main.po;

import java.io.Serializable;
import java.util.ArrayList;

public class CityPO extends Message implements Serializable{
	/**
	 * Ȩ�޹�������½�Ȩ�޸��³���������
	 */
	private static final long serialVersionUID = 1L;
	private  String cityName;
	private ArrayList<String > insititutionNum=new ArrayList<String>();
	
	public ArrayList<String> getInsititutionNum() {
		return insititutionNum;
	}
	public void setInsititutionNum(ArrayList<String> insititutionNum) {
		this.insititutionNum = insititutionNum;
	}
//	public CityPO(String ci){
//		super();
//		ci=cityName;
//	}
//	public CityPO(){
//		
//	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
