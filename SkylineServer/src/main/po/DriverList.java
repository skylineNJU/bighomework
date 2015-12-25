package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class DriverList extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<DriverInfoPO> driverlist=new ArrayList<DriverInfoPO>();
	
	public ArrayList<DriverInfoPO> getDriverlist() {
		return driverlist;
	}

	public void add(DriverInfoPO po){
		driverlist.add(po);
	}

	public void getDataFromBase(){
		System.out.println("inquire start");
		SqlReader reader=new SqlReader("DriverInfo");
		String key=driverlist.get(0).getCarunit();
		driverlist.clear();
		String name;
		while(reader.findNext("司机所在单位",key)){
			DriverInfoPO driverinfo=new DriverInfoPO(
					reader.getString("司机编号"),
					name=reader.getString("司机姓名"),
					reader.getString("司机出生日期"),
					reader.getString("司机身份证号"),
					reader.getString("司机手机号码"),
					reader.getString("司机性别"),
					reader.getString("司机行驶证期限"),
					key);
			driverlist.add(driverinfo);
			System.out.println("get a driver "+name);
		}
	}

}
