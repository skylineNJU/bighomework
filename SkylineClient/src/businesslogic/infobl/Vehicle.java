package businesslogic.infobl;

import po.VehicleInfoPO;
import vo.VehicleVO;

public class Vehicle {
	private int carID;//车辆代号
	private int engineID;//底盘代号
	private int carNum;//车辆号
	private int underpanID;//底盘号
	private String boughtTime;//购买时间
	private int usedTime;//服役时间
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
	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public int getEngineID() {
		return engineID;
	}

	public void setEngineID(int engineID) {
		this.engineID = engineID;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	public int getUnderpanID() {
		return underpanID;
	}

	public void setUnderpanID(int underpanID) {
		this.underpanID = underpanID;
	}

	public String getBoughtTime() {
		return boughtTime;
	}

	public void setBoughtTime(String boughtTime) {
		this.boughtTime = boughtTime;
	}

	public int getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(int usedTime) {
		this.usedTime = usedTime;
	}
}
