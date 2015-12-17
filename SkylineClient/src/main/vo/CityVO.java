package main.vo;

import java.util.ArrayList;

public class CityVO {
	private static final long serialVersionUID = 1L;
	private  String cityName;
	private ArrayList<String > insititutionNum=new ArrayList<String>();
	
	public CityVO(String cityName, ArrayList<String > insititutionNum){
		this.cityName=cityName;
		this.insititutionNum=insititutionNum;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public ArrayList<String> getInsititutionNum() {
		return insititutionNum;
	}
	public void setInsititutionNum(ArrayList<String> insititutionNum) {
		this.insititutionNum = insititutionNum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
