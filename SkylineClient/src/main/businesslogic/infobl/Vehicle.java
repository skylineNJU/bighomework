package main.businesslogic.infobl;

import main.po.VehicleInfoPO;
import main.vo.VehicleVO;

public class Vehicle {
	private String carID;//车辆代号
	private String engineID;//底盘代号
	private String carNum;//车辆号
	private String underpanID;//底盘号
	private String boughtTime;//购买时间
	private String usedTime;//服役时间
	private VehicleInfoPO po;
	public Vehicle(VehicleVO vo){
		this.carID=vo.getCarID();
		this.engineID=vo.getEngineID();
		this.carNum=vo.getCarNum();
		this.underpanID=vo.getUnderpanID();
		this.boughtTime=vo.getBoughtTime();
		this.usedTime=vo.getUsedTime();
	}
	
	public Vehicle(String vehicleCode){
		if(inquire(vehicleCode)){
			this.carID=po.getCarID();
			this.engineID=po.getEngineID();
			this.carNum=po.getCarNum();
			this.underpanID=po.getUnderpanID();
			this.boughtTime=po.getBoughtTime();
			this.usedTime=po.getUsedTime();
		}
	}
	public boolean inquire(String vehicleCode){
		return true;
	}
	
	public boolean saveInfo(){
		return true;
	}
	
	public boolean modify(){
		return true;
	}
	
	public static boolean delete(String vehicleCode){
		return true;
	}
	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getEngineID() {
		return engineID;
	}

	public void setEngineID(String engineID) {
		this.engineID = engineID;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getUnderpanID() {
		return underpanID;
	}

	public void setUnderpanID(String underpanID) {
		this.underpanID = underpanID;
	}

	public String getBoughtTime() {
		return boughtTime;
	}

	public void setBoughtTime(String boughtTime) {
		this.boughtTime = boughtTime;
	}

	public String getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(String usedTime) {
		this.usedTime = usedTime;
	}
}
