package main.po;

import java.io.Serializable;
import java.util.ArrayList;

import main.socketservice.SqlReader;

public class CityPO extends Message implements Serializable{
	/**
	 * 权限管理界面新建权限更新城市下拉框
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
public void getDataFromBase(){
	SqlReader reader=new SqlReader("IntermediateInfo");
	cityName="";
	while(reader.hasNext()){
		String city=reader.getString("所在城市");
		String result=reader.getString("机构编号");
		result=result+" "+this.readLobbyInfo(city);
		cityName=cityName+" "+city;
		insititutionNum.add(result);
	}
}
public String readLobbyInfo(String city){
	SqlReader reader=new SqlReader("LobbyInfo");
	String result="";
	while(reader.findNext("所在城市", city)){
		result=result+" "+reader.getString("机构编号");
	}
	return result;
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
