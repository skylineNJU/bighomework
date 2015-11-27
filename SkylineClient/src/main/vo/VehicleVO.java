package main.vo;

import main.businesslogic.infobl.Vehicle;

public class VehicleVO {
	private String carID;//��������
	private String engineID;//���̴���
	private String carNum;//������
	private String underpanID;//���̺�
	private String boughtTime;//����ʱ��
	private String usedTime;//����ʱ��

	
	
	public VehicleVO(String carID, String engineID, String carNum, String underpanID, String boughtTime,
			String usedTime) {
		super();
		this.carID = carID;
		this.engineID = engineID;
		this.carNum = carNum;
		this.underpanID = underpanID;
		this.boughtTime = boughtTime;
		this.usedTime = usedTime;
	}

	public boolean writeVehicleInfo(Vehicle ve){
		this.carID=ve.getCarID();
		this.carNum=ve.getCarNum();
		this.engineID=ve.getEngineID();
		this.underpanID=ve.getUnderpanID();
		this.usedTime=ve.getUsedTime();
		this.boughtTime=ve.getBoughtTime();
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
