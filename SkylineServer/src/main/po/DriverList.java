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
		while(reader.findNext("˾�����ڵ�λ",key)){
			DriverInfoPO driverinfo=new DriverInfoPO(
					reader.getString("˾�����"),
					name=reader.getString("˾������"),
					reader.getString("˾����������"),
					reader.getString("˾�����֤��"),
					reader.getString("˾���ֻ�����"),
					reader.getString("˾���Ա�"),
					reader.getString("˾����ʻ֤����"),
					key);
			driverlist.add(driverinfo);
			System.out.println("get a driver "+name);
		}
	}

}
