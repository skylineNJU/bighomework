package main.po;

import java.io.Serializable;
import java.util.ArrayList;

public class CityPO extends Message implements Serializable{
	/**
	 * Ȩ�޹�������½�Ȩ�޸��³���������
	 */
	private static final long serialVersionUID = 1L;
	private  String cityName;
	
	public CityPO(String ci){
		super();
		ci=cityName;
	}
	public CityPO(){
		
	}
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
